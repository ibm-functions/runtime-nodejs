package actionContainers

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class IBMNodeJsActionContainerTests extends IBMNodeJsActionContainerTests {

  override lazy val nodejsContainerImageName = "action-nodejs-ibm-v8.5"

}
