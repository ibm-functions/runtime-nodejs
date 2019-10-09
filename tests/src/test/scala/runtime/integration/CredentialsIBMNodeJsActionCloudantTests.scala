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
package runtime.integration

import common.{TestHelpers, WhiskProperties, WskActorSystem, WskProps, WskTestHelpers}
import common.rest.WskRestOperations
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import java.io.File
import spray.json._
import scala.io.Source

@RunWith(classOf[JUnitRunner])
class CredentialsIBMNodeJsActionCloudantTests extends TestHelpers with WskTestHelpers with WskActorSystem {

  implicit val wskprops: WskProps = WskProps()
  lazy val defaultKind = Some("nodejs:8")
  val wsk = new WskRestOperations
  val datdir = "tests/dat/"

  // read credentials from from vcap_services.json
  val vcapFile = WhiskProperties.getProperty("vcap.services.file")
  val vcapString = Source.fromFile(vcapFile).getLines.mkString
  val vcapInfo =
    JsonParser(ParserInput(vcapString)).asJsObject.fields("cloudantNoSQLDB").asInstanceOf[JsArray].elements(0)
  val creds = vcapInfo.asJsObject.fields("credentials").asJsObject
  val username = creds.fields("username").asInstanceOf[JsString]
  val password = creds.fields("password").asInstanceOf[JsString]

  it should "Test whether or not cloudant database is reachable using cloudant npm module" in withAssetCleaner(wskprops) {
    (wp, assetHelper) =>
      val file = Some(new File(datdir, "cloudant/testCloudantAction.js").toString())

      assetHelper.withCleaner(wsk.action, "testCloudantAction") { (action, _) =>
        action.create(
          "testCloudantAction",
          file,
          main = Some("main"),
          kind = defaultKind,
          parameters = Map("username" -> username, "password" -> password))
      }

      withActivation(wsk.activation, wsk.action.invoke("testCloudantAction")) { activation =>
        val response = activation.response
        response.result.get.fields.get("error") shouldBe empty
        response.result.get.fields.get("lastname") should be(Some(JsString("Queue")))
      }

  }

}
