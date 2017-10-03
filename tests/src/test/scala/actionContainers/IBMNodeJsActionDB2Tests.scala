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
import common.TestUtils
import scala.collection.mutable.ArrayBuffer

@RunWith(classOf[JUnitRunner])
class IBMNodeJsActionDB2Tests extends TestHelpers with WskTestHelpers {

  implicit val wskprops: WskProps = WskProps()
  var defaultKind = Some("nodejs-ibm:8")
  val wsk = new Wsk
  val userdir = System.getProperty("user.dir") + "/dat/"

  //example syntax: val result = runShellScript("docker ps -a")
  def runShellScript(cmd: String): TestUtils.RunResult = {
    val cmdParts = ArrayBuffer[String]();
    var openQuote = false;
    var strBuilder = "";
    for (c <- cmd) {
      if (!openQuote && c == ' ') { //Space found outside of a quoted area
        cmdParts.append(strBuilder);
        strBuilder = ""
      } else if (c == '"') {
        //strBuilder += "\"" - Note: ProcessBuilder (underlying functionality) does not play well with quotes.
        if (!openQuote) {
          openQuote = true
        } else {
          openQuote = false
        }
      } else {
        strBuilder += c
      }
    }
    cmdParts.append(strBuilder)

    TestUtils.runCmd(0, (new File(System.getProperty("user.dir"))), cmdParts: _*)
  }

  it should "Test creation, get, and delete of a nodejs8 action" in withAssetCleaner(wskprops) { (wp, assetHelper) =>
    //setup db2 docker container
    var result = runShellScript(
      "docker run -d -p 50000:50000 -e DB2INST1_PASSWORD=db2inst1-pwd -e LICENSE=accept --name db2test ibmcom/db2express-c:latest db2start")
    result.exitCode should equal(0)
    result = runShellScript("sleep 30")
    result.exitCode should equal(0)

    //place setup sql script on docker container; then run it to initialize the initial database and tables
    result = runShellScript(
      "docker cp " + System.getProperty("user.dir") + "/../tools/travis/setup.sql db2test:/home/db2inst1/setup.sql")
    result.exitCode should equal(0)
    result = runShellScript("docker exec -t --user db2inst1 db2test bash -c \"~/sqllib/bin/db2 -tvf ~/setup.sql\"")
    result.exitCode should equal(0)

    val file = Some(new File(userdir, "testdb2action.js").toString())

    assetHelper.withCleaner(wsk.action, "testdb2action") { (action, _) =>
      action.create(
        "testdb2action",
        file,
        main = Some("main"),
        kind = defaultKind,
        parameters = Map("hostname" -> wskprops.apihost.toJson))
    }

    withActivation(wsk.activation, wsk.action.invoke("testdb2action")) { activation =>
      val response = activation.response
      response.result.get.fields.get("error") shouldBe empty
      response.result.get.fields.get("message") should be(
        Some(JsString("Tested db2 create, select, and delete of a table row.")))
    }

    //clean up db2 container resources
    result = runShellScript("docker stop db2test")
    result = runShellScript("docker rm db2test")
    result.exitCode should equal(0)
  }

}
