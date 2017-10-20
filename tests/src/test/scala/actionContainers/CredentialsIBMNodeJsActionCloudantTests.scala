package actionContainers

import common.TestHelpers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import common.WskTestHelpers
import common.Wsk
import common.WskProps
import java.io.File
import spray.json._
import common.TestUtils

@RunWith(classOf[JUnitRunner])
class CredentialsIBMNodeJsActionCloudantTests extends TestHelpers with WskTestHelpers {

  implicit val wskprops: WskProps = WskProps()
  var defaultKind = Some("nodejs-ibm:8")
  val wsk = new Wsk
  val datdir = System.getProperty("user.dir") + "/dat/"
  var creds = TestUtils.getVCAPcredentials("cloudantNoSQLDB")

  it should "Test whether or not cloudant npm module is useable within a nodejs8 action" in withAssetCleaner(wskprops) {
    (wp, assetHelper) =>
      val file = Some(new File(datdir, "testCloudantAction.js").toString())

      assetHelper.withCleaner(wsk.action, "testCloudantAction") { (action, _) =>
        action.create(
          "testCloudantAction",
          file,
          main = Some("main"),
          kind = defaultKind,
          parameters = Map("username" -> JsString(creds.get("username")), "password" -> JsString(creds.get("password"))))
      }

      withActivation(wsk.activation, wsk.action.invoke("testCloudantAction")) { activation =>
        val response = activation.response
        response.result.get.fields.get("error") shouldBe empty
        response.result.get.fields.get("lastname") should be(Some(JsString("Queue")))
      }

  }

}
