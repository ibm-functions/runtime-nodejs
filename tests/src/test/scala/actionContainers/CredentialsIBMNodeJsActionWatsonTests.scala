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
import org.scalatest.BeforeAndAfterAll
@RunWith(classOf[JUnitRunner])
class CredentialsIBMNodeJsActionWatsonTests extends TestHelpers with WskTestHelpers with BeforeAndAfterAll {

  implicit val wskprops: WskProps = WskProps()
  var defaultKind = Some("nodejs-ibm:8")
  val wsk = new Wsk
  val datdir = System.getProperty("user.dir") + "/dat/"

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
