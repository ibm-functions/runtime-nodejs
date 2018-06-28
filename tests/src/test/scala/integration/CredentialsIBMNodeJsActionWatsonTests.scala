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
package integration

import common.{TestHelpers, TestUtils, WskActorSystem, WskProps, WskTestHelpers}
import common.rest.WskRestOperations
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import java.io.File
import spray.json._
import org.scalatest.BeforeAndAfterAll

@RunWith(classOf[JUnitRunner])
class CredentialsIBMNodeJsActionWatsonTests
    extends TestHelpers
    with WskTestHelpers
    with BeforeAndAfterAll
    with WskActorSystem {

  implicit val wskprops: WskProps = WskProps()
  var defaultKind = Some("nodejs:8")
  val wsk = new WskRestOperations
  val datdir = "tests/dat/"

  var creds = TestUtils.getVCAPcredentials("language_translator")

  /*
    Uses Watson Translation Service to translate the word "Hello" in English, to "Hola" in Spanish.
   */
  it should "Test whether watson translate service is reachable" in withAssetCleaner(wskprops) { (wp, assetHelper) =>
    val file = Some(new File(datdir, "testWatsonAction2.js").toString())
    assetHelper.withCleaner(wsk.action, "testWatsonAction2") { (action, _) =>
      action.create(
        "testWatsonAction2",
        file,
        main = Some("main"),
        kind = defaultKind,
        parameters = Map(
          "url" -> JsString(creds.get("url")),
          "username" -> JsString(creds.get("username")),
          "password" -> JsString(creds.get("password"))))
    }

    withActivation(wsk.activation, wsk.action.invoke("testWatsonAction2")) { activation =>
      val response = activation.response
      response.result.get.fields.get("error") shouldBe empty
      response.result.get.fields.get("translations") should be(
        Some(JsArray(JsObject("translation" -> JsString("Hola")))))
    }

  }

}
