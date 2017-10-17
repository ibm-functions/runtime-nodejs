package actionContainers

import common.TestHelpers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import common.WskTestHelpers
import common.Wsk
import common.WskProps
import java.io.File
import spray.json._
import spray.json.DefaultJsonProtocol._
import org.scalatest.BeforeAndAfterAll
@RunWith(classOf[JUnitRunner])
class IBMNodeJsActionWatsonTests extends TestHelpers with WskTestHelpers with BeforeAndAfterAll {

  implicit val wskprops: WskProps = WskProps()
  var defaultKind = Some("nodejs-ibm:8")
  val wsk = new Wsk
  val datdir = System.getProperty("user.dir") + "/dat/"

  it should "Test whether or not watson package is useable within a nodejs8 action" in withAssetCleaner(wskprops) {
    (wp, assetHelper) =>
      /*
     Disclaimer : Does not Use / Connect to a watson service! Tests that the
     watson-developer-cloud npm package is useable by verifying creating a new
     discover object creates the expected object with the expected properties.
       */

      val file = Some(new File(datdir, "testWatsonAction.js").toString())

      assetHelper.withCleaner(wsk.action, "testWatsonAction") { (action, _) =>
        action.create(
          "testWatsonAction",
          file,
          main = Some("main"),
          kind = defaultKind,
          parameters = Map("hostname" -> wskprops.apihost.toJson))
      }

      withActivation(wsk.activation, wsk.action.invoke("testWatsonAction")) { activation =>
        val response = activation.response
        response.result.get.fields.get("error") shouldBe empty
        response.result.get.fields.get("message") should be(Some(JsString("2017-08-01")))
      }

  }

}
