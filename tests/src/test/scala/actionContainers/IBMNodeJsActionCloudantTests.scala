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
package actionContainers

import common.TestHelpers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import common.WskTestHelpers
import common.WskProps
import java.io.File
import common.rest.WskRest
import spray.json._
import org.scalatest.BeforeAndAfterAll

@RunWith(classOf[JUnitRunner])
class IBMNodeJsActionCloudantTests extends TestHelpers with WskTestHelpers with BeforeAndAfterAll {

  implicit val wskprops: WskProps = WskProps()
  var defaultKind = Some("nodejs:8")
  val wsk = new WskRest
  val datdir = System.getProperty("user.dir") + "/dat/"

  it should "Test whether or not cloudant package is accessible within a nodejs8 action" in withAssetCleaner(wskprops) {
    (wp, assetHelper) =>
      val file = Some(new File(datdir, "testCloudantActionNoCreds.js").toString())

      assetHelper.withCleaner(wsk.action, "testCloudantActionNoCreds") { (action, _) =>
        action.create("testCloudantActionNoCreds", file, main = Some("main"), kind = defaultKind)
      }

      withActivation(wsk.activation, wsk.action.invoke("testCloudantActionNoCreds")) { activation =>
        val response = activation.response
        response.result.get.fields.get("error") shouldBe empty
        response.result.get.fields.get("message") should be(Some(JsString("cloudant url formed successfully")))
      }

  }

}
