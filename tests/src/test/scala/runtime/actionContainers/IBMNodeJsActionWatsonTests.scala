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
package runtime.actionContainers

import common.{TestHelpers, WskActorSystem, WskProps, WskTestHelpers}
import common.rest.WskRestOperations
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import java.io.File
import spray.json._
import spray.json.DefaultJsonProtocol._
import org.scalatest.BeforeAndAfterAll

@RunWith(classOf[JUnitRunner])
class IBMNodeJsActionWatsonTests extends TestHelpers with WskTestHelpers with BeforeAndAfterAll with WskActorSystem {

  implicit val wskprops: WskProps = WskProps()
  lazy val defaultKind = "nodejs:8"
  val wsk = new WskRestOperations
  val datdir = "tests/dat/"

  it should s"""Test whether or not watson package is useable within a $defaultKind action""" in withAssetCleaner(
    wskprops) { (wp, assetHelper) =>
    /*
     Disclaimer : Does not Use / Connect to a watson service! Tests that the
     watson-developer-cloud npm package is useable by verifying creating a new
     discover object creates the expected object with the expected properties.
     */

    val file = Some(new File(datdir, "watson/testWatsonAction.js").toString())

    assetHelper.withCleaner(wsk.action, "testWatsonAction") { (action, _) =>
      action.create(
        "testWatsonAction",
        file,
        main = Some("main"),
        kind = Some(defaultKind),
        parameters = Map("hostname" -> wskprops.apihost.toJson))
    }

    withActivation(wsk.activation, wsk.action.invoke("testWatsonAction")) { activation =>
      val response = activation.response
      response.result.get.fields.get("error") shouldBe empty
      response.result.get.fields.get("message") should be(Some(JsString("2017-09-01")))
    }

  }

}
