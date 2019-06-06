/*
 * Copyright 2017 IBM Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package runtime.sdk

import java.io.File
import scala.concurrent.duration.DurationInt
import scala.language.postfixOps
import common._
import org.apache.openwhisk.core.entity.Annotations
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import spray.json._
import spray.json.DefaultJsonProtocol.StringJsonFormat

@RunWith(classOf[JUnitRunner])
class NodeJsSDKTests extends TestHelpers with WskTestHelpers with WskActorSystem {

  implicit val wskprops = WskProps()
  val wsk = new Wsk
  val activationPollDuration = 2.minutes
  lazy val actionKind = "nodejs:8"
  lazy val actionTypeDir: String = "tests/dat/sdk/"
  val controllerHost = WhiskProperties.getBaseControllerHost()
  val controllerPort = WhiskProperties.getControllerBasePort()
  val baseUrl = s"http://$controllerHost:$controllerPort"
  //when running tests on environment with valid ssl certs in whisk host then pass -DswiftUseSSLWhiskHost=true
  val ignoreSSL = "true" != System.getProperty("nodeUseSSLWhiskHost")

  behavior of s"Nodejs Whisk SDK tests using $actionKind"

  it should "allow NodeJS actions to invoke other actions" in withAssetCleaner(wskprops) { (wp, assetHelper) =>
    val file = Some(new File(actionTypeDir, "invoke.js").toString())

    val actionName = "invokeAction"
    assetHelper.withCleaner(wsk.action, actionName) { (action, _) =>
      action.create(
        name = actionName,
        artifact = file,
        kind = Some(actionKind),
        annotations = Map(Annotations.ProvideApiKeyAnnotationName -> JsBoolean(true)))
    }
    // invoke the action
    var params = Map("dummy" -> JsString("dummy"), "ignore_certs" -> JsBoolean(ignoreSSL))

    val run = wsk.action.invoke(actionName, params)
    withActivation(wsk.activation, run, initialWait = 5 seconds, totalWait = activationPollDuration) { activation =>
      // should be successful
      activation.response.success shouldBe true

      // should have a field named "activationId" which is the date action's activationId
      activation.response.result.get.fields("activationId").toString.length should be >= 32

      val myresponse = activation.response.result.get.fields("response")
      val myresult = myresponse.asJsObject().fields("result")

      myresult.asJsObject().fields.get("date") shouldBe defined
      myresult.asJsObject().fields("date").toString.length should be > 10
    }
  }

  it should "allow NodeJs actions to trigger events" in withAssetCleaner(wskprops) { (wp, assetHelper) =>
    // create a trigger
    val triggerName = s"TestTrigger ${System.currentTimeMillis()}"
    val ruleName = s"TestTriggerRule ${System.currentTimeMillis()}"
    val ruleActionName = s"TestTriggerAction ${System.currentTimeMillis()}"
    assetHelper.withCleaner(wsk.trigger, triggerName) { (trigger, _) =>
      trigger.create(triggerName)
    }

    // create a dummy action
    assetHelper.withCleaner(wsk.action, ruleActionName) { (action, name) =>
      val dummyFile = Some(new File(actionTypeDir, "hello.js").toString())
      action.create(
        name,
        dummyFile,
        kind = Some(actionKind),
        annotations = Map(Annotations.ProvideApiKeyAnnotationName -> JsBoolean(true)))
    }
    // create a dummy rule
    assetHelper.withCleaner(wsk.rule, ruleName) { (rule, name) =>
      rule.create(name, trigger = triggerName, action = ruleActionName)
    }

    // create an action that fires the trigger
    val file = Some(new File(actionTypeDir, "trigger.js").toString())
    val actionName = "ActionThatTriggers"
    assetHelper.withCleaner(wsk.action, actionName) { (action, _) =>
      action.create(
        name = actionName,
        file,
        kind = Some(actionKind),
        annotations = Map(Annotations.ProvideApiKeyAnnotationName -> JsBoolean(true)))
    }

    // invoke the action
    var params = Map("triggerName" -> JsString(triggerName), "ignore_certs" -> JsBoolean(ignoreSSL))

    val run = wsk.action.invoke(actionName, params)
    withActivation(wsk.activation, run, initialWait = 5 seconds, totalWait = activationPollDuration) { activation =>
      // should be successful
      activation.response.success shouldBe true

      // should have a field named "activationId" which is the date action's activationId
      activation.response.result.get.fields("activationId").toString.length should be >= 32

      // should result in an activation for triggerName
      val triggerActivations = wsk.activation.pollFor(1, Some(triggerName), retries = 20)
      withClue(s"trigger activations for $triggerName:") {
        triggerActivations.length should be(1)
      }
    }
  }

  it should "allow NodeJs actions to create a trigger" in withAssetCleaner(wskprops) { (wp, assetHelper) =>
    // create an action that creates the trigger
    val file = Some(new File(actionTypeDir, "createTrigger.js").toString())
    val actionName = "ActionThatTriggers"

    // the name of the trigger to create
    val triggerName = s"TestTrigger ${System.currentTimeMillis()}"

    assetHelper.withCleaner(wsk.action, actionName) { (action, _) =>
      assetHelper.withCleaner(wsk.trigger, triggerName) { (_, _) =>
        // using an asset cleaner on the created trigger name will clean it up at the conclusion of the test
        action.create(
          name = actionName,
          file,
          kind = Some(actionKind),
          annotations = Map(Annotations.ProvideApiKeyAnnotationName -> JsBoolean(true)))
      }
    }

    // invoke the action
    var params = Map("triggerName" -> JsString(triggerName), "ignore_certs" -> JsBoolean(ignoreSSL))

    val run = wsk.action.invoke(actionName, params)
    withActivation(wsk.activation, run, initialWait = 5 seconds, totalWait = activationPollDuration) { activation =>
      // should be successful
      activation.response.success shouldBe true

      // should have a field named "name" which is the name of the trigger created
      activation.response.result.get.fields("name") shouldBe JsString(triggerName)
    }
  }

  it should "allow NodeJs actions to create a rule" in withAssetCleaner(wskprops) { (wp, assetHelper) =>
    val ruleTriggerName = s"TestTrigger ${System.currentTimeMillis()}"
    val ruleActionName = s"TestAction ${System.currentTimeMillis()}"
    val ruleName = s"TestRule ${System.currentTimeMillis()}"

    // create a dummy action and trigger for the rule
    assetHelper.withCleaner(wsk.action, ruleActionName) { (action, name) =>
      val dummyFile = Some(new File(actionTypeDir, "hello.js").toString())
      action.create(
        name,
        dummyFile,
        kind = Some(actionKind),
        annotations = Map(Annotations.ProvideApiKeyAnnotationName -> JsBoolean(true)))
    }

    assetHelper.withCleaner(wsk.trigger, ruleTriggerName) { (trigger, name) =>
      assetHelper.withCleaner(wsk.rule, ruleName) { (_, _) =>
        // using an asset cleaner on the created trigger name will clean it up at the conclusion of the test
        trigger.create(name)
      }
    }

    // create an action that creates the rule
    val createRuleFile = Some(new File(actionTypeDir, "createRule.js").toString())
    assetHelper.withCleaner(wsk.action, "ActionThatCreatesRule") { (action, name) =>
      action.create(
        name,
        createRuleFile,
        kind = Some(actionKind),
        annotations = Map(Annotations.ProvideApiKeyAnnotationName -> JsBoolean(true)))
    }

    // invoke the create rule action
    var params = Map(
      "triggerName" -> s"/_/$ruleTriggerName".toJson,
      "actionName" -> s"/_/$ruleActionName".toJson,
      "ruleName" -> ruleName.toJson,
      "ignore_certs" -> JsBoolean(ignoreSSL))

    val run = wsk.action.invoke("ActionThatCreatesRule", params)
    withActivation(wsk.activation, run, initialWait = 5 seconds, totalWait = activationPollDuration) { activation =>
      // should be successful
      activation.response.success shouldBe true

      // should have a field named "trigger" which is the name of the trigger associated with the rule
      activation.response.result.get.fields("trigger").asJsObject.fields("name") shouldBe ruleTriggerName.toJson

      // should have a field named "action" which is the name of the action associated with the rule
      activation.response.result.get.fields("action").asJsObject.fields("name") shouldBe ruleActionName.toJson
    }
  }

}
