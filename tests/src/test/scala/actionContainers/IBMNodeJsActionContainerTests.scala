package actionContainers

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class IBMNodeJsActionContainerTests extends NodeJsActionContainerTests {

  override lazy val nodejsContainerImageName = "action-nodejs-ibm-v8.5"

}
