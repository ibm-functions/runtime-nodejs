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
  lazy val defaultKind = "nodejs:8"
  val wsk = new WskRestOperations
  val db2dir = "tests/dat/db2/"
  val db2containerName = "db2test"

  it should s"""Test creation, get, and delete of a $defaultKind action""" in withAssetCleaner(wskprops) {
    (wp, assetHelper) =>
      val file = Some(new File(db2dir, "testdb2action.js").toString())

      assetHelper.withCleaner(wsk.action, "testdb2action") { (action, _) =>
        action.create(
          "testdb2action",
          file,
          main = Some("main"),
          kind = Some(defaultKind),
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
  exitCode 8 = SQL10007N Message "-1390" could not be retrieved.  Reason code: "3".
  exitCode 126 = stat /database/config/db2inst1/sqllib/bin/db2: no such file or directory.
  exitCode 127 = /database/config/db2inst1/sqllib/bin/db2: No such file or directory.
   */
  def sleepUntilContainerRunning() {
    var counter = 48; // 48*5s=240s -> 4 minutes
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
          "bash",
          "-c",
          ". /database/config/db2inst1/.bashrc && db2 list active databases")

      if ((isdb2Running.exitCode != 0) && (isdb2Running.exitCode != 2)) {
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
      "--cap-add",
      "IPC_LOCK",
      "--cap-add",
      "IPC_OWNER",
      "-p",
      "50000:50000",
      "-e",
      "DB2INSTANCE=db2inst1",
      "-e",
      "DB2INST1_PASSWORD=db2inst1-pwd",
      "-e",
      "LICENSE=accept",
      "--name",
      db2containerName,
      "ibmcom/db2")

    sleepUntilContainerRunning()

    //place setup sql script on docker container; then run it to initialize the initial database and tables
    TestUtils.runCmd(
      0,
      new File("."),
      "docker",
      "cp",
      db2dir + "setup.sql",
      db2containerName + ":/database/config/db2inst1/setup.sql")
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
      "bash",
      "-c",
      ". /database/config/db2inst1/.bashrc && db2 -tvf /database/config/db2inst1/setup.sql")
  }

  override def afterAll() {
    TestUtils.runCmd(TestUtils.DONTCARE_EXIT, new File("."), "docker", "kill", db2containerName)
    TestUtils.runCmd(TestUtils.DONTCARE_EXIT, new File("."), "docker", "rm", db2containerName)
  }

}
