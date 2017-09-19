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
  var defaultKind = Some("nodejs-ibm:8.5")

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
