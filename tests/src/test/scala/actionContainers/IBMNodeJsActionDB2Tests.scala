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
import org.scalatest.BeforeAndAfterAll

@RunWith(classOf[JUnitRunner])
class IBMNodeJsActionDB2Tests extends TestHelpers with WskTestHelpers with BeforeAndAfterAll {

  implicit val wskprops: WskProps = WskProps()
  var defaultKind = Some("nodejs-ibm:8")
  val wsk = new Wsk
  val userdir = System.getProperty("user.dir")
  val db2dir = userdir + "/dat/db2/"

  /*
    Runs the supplied shell script and returns the result in the form of the TestUtils.RunResult object
      RunResult.stdout : String of standard output
      RunResult.stderr : String of standard error
      RunResult.exitCode : successful code is 0; otherwise another number

    Example usage:
    val result = runShellScript("docker ps -a")
    println("Expecting: 0; Actual: " + result.exitCode)
   */
  def runShellScript(cmd: String): TestUtils.RunResult = {
    val cmdParts = ArrayBuffer[String]();
    var openQuote = false;
    var strBuilder = "";
    for (c <- cmd) {
      if (!openQuote && c == ' ') { //Space found outside of a quoted area
        cmdParts.append(strBuilder)
        strBuilder = ""
      } else if (c == '"') { //A quote encountered
        //strBuilder += "\"" - Note: ProcessBuilder (underlying functionality) does not play well with quotes.
        if (!openQuote) {
          openQuote = true
        } else {
          openQuote = false
          cmdParts.append(strBuilder)
          strBuilder = ""
        }
      } else {
        strBuilder += c
      }
    }
    if (strBuilder.length > 0) {
      cmdParts.append(strBuilder)
    }

    TestUtils.runCmd(0, (new File(userdir)), cmdParts: _*)
  }

  it should "Test creation, get, and delete of a nodejs8 action" in withAssetCleaner(wskprops) { (wp, assetHelper) =>
    val file = Some(new File(db2dir, "testdb2action.js").toString())

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

  }

  override def beforeAll() {
    //setup db2 docker container
    var result = runShellScript(
      "docker run -d -p 50000:50000 -e DB2INST1_PASSWORD=db2inst1-pwd -e LICENSE=accept --name db2test ibmcom/db2express-c:latest db2start")
    result.exitCode should equal(0)
    Thread.sleep(30000)

    //place setup sql script on docker container; then run it to initialize the initial database and tables
    result = runShellScript("docker cp " + db2dir + "setup.sql db2test:/home/db2inst1/setup.sql")
    result.exitCode should equal(0)
    result = runShellScript("docker exec -t --user db2inst1 db2test bash -c \"~/sqllib/bin/db2 -tvf ~/setup.sql\"")
    result.exitCode should equal(0)
  }

  override def afterAll() {
    //clean up db2 container resources
    if ((runShellScript("docker inspect -f {{.State.Running}} db2test")).stdout.trim == "true") {
      runShellScript("docker stop db2test")
    }
    runShellScript("docker rm db2test")
  }

}
