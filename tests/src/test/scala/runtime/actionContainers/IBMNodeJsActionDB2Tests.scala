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

import common.{TestHelpers, TestUtils, WskActorSystem, WskProps, WskTestHelpers}
import common.rest.WskRestOperations
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import java.io.File
import spray.json._
import spray.json.DefaultJsonProtocol._
import org.scalatest.BeforeAndAfterAll

@RunWith(classOf[JUnitRunner])
class IBMNodeJsActionDB2Tests extends TestHelpers with WskTestHelpers with BeforeAndAfterAll with WskActorSystem {

  implicit val wskprops: WskProps = WskProps()
  var defaultKind = Some("nodejs:8")
  val wsk = new WskRestOperations
  val db2dir = "tests/dat/db2/"
  val db2containerName = "db2test"

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

  /*
  Need to wait till the db2 start command has completed.
  The following executes a `db2 list active databases` commands and if the start
  command wasn't completed, it will return an exitCode 4.
  Other exit codes are acceptable, for example 2 means that there was no active databases
  exitCode 4 = SQL1032N  No start database manager command was issued.
  exitCode 2 = SQL1611W  No data was returned by Database System Monitor.
   */
  def sleepUntilContainerRunning() {
    var counter = 5;
    var running = false;
    do {
      counter = counter - 1
      val isdb2Running = TestUtils
        .runCmd(
          TestUtils.DONTCARE_EXIT,
          new File("."),
          "docker",
          "exec",
          "-t",
          "--user",
          "db2inst1",
          db2containerName,
          "/home/db2inst1/sqllib/bin/db2",
          "list",
          "active",
          "databases")

      if (isdb2Running.exitCode == 4) {
        Thread.sleep(5000)
      } else {
        running = true;
      }
    } while (counter > 0 && running == false);
  }

  override def beforeAll() {
    //setup db2 docker container

    TestUtils.runCmd(TestUtils.DONTCARE_EXIT, new File("."), "docker", "kill", db2containerName)
    TestUtils.runCmd(TestUtils.DONTCARE_EXIT, new File("."), "docker", "rm", db2containerName)
    TestUtils.runCmd(
      0,
      new File("."),
      "docker",
      "run",
      "-d",
      "-p",
      "50000:50000",
      "-e",
      "DB2INST1_PASSWORD=db2inst1-pwd",
      "-e",
      "LICENSE=accept",
      "--name",
      db2containerName,
      "ibmcom/db2express-c",
      "db2start")

    sleepUntilContainerRunning()

    //place setup sql script on docker container; then run it to initialize the initial database and tables
    TestUtils.runCmd(
      0,
      new File("."),
      "docker",
      "cp",
      db2dir + "setup.sql",
      db2containerName + ":/home/db2inst1/setup.sql")
    println("Creating db2 database, might take up to 5 minutes")
    TestUtils.runCmd(
      0,
      new File("."),
      "docker",
      "exec",
      "-t",
      "--user",
      "db2inst1",
      db2containerName,
      "/home/db2inst1/sqllib/bin/db2",
      "-tvf",
      "/home/db2inst1/setup.sql")
  }

  override def afterAll() {
    TestUtils.runCmd(TestUtils.DONTCARE_EXIT, new File("."), "docker", "kill", db2containerName)
    TestUtils.runCmd(TestUtils.DONTCARE_EXIT, new File("."), "docker", "rm", db2containerName)
  }

}
