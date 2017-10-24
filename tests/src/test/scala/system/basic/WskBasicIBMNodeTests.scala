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

package system.basic

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import common.JsHelpers
import common.TestHelpers
import common.TestUtils
import common.Wsk
import common.WskProps
import common.WskTestHelpers
import spray.json._

@RunWith(classOf[JUnitRunner])
class WskBasicIBMNodeTests extends TestHelpers with WskTestHelpers with JsHelpers {

  implicit val wskprops: WskProps = WskProps()
  val wsk = new Wsk
  var defaultKind = Some("nodejs-ibm:8")

  behavior of s"Basic NodeJS runtime with kind ${defaultKind.get}"

  it should s"Ensure that actions can have a non-default entry point" in withAssetCleaner(wskprops) {
    (wp, assetHelper) =>
      val name = "niamNpmAction"
      val file = Some(TestUtils.getTestActionFilename("niam.js"))

      assetHelper.withCleaner(wsk.action, name) { (action, _) =>
        action.create(name, file, main = Some("niam"), kind = defaultKind)
      }

      withActivation(wsk.activation, wsk.action.invoke(name)) { activation =>
        val response = activation.response
        response.result.get.fields.get("error") shouldBe empty
        response.result.get.fields.get("greetings") should be(Some(JsString("Hello from a non-standard entrypoint.")))
      }
  }

  it should "Ensure that returning an empty rejected Promise results in an errored activation" in withAssetCleaner(
    wskprops) { (wp, assetHelper) =>
    val name = "jsEmptyRejectPromise"

    assetHelper.withCleaner(wsk.action, name) { (action, _) =>
      action.create(name, Some(TestUtils.getTestActionFilename("issue-1562.js")), kind = defaultKind)
    }

    withActivation(wsk.activation, wsk.action.invoke(name)) { activation =>
      val response = activation.response
      response.success should be(false)
      response.result.get.fields.get("error") shouldBe defined
    }
  }

}
