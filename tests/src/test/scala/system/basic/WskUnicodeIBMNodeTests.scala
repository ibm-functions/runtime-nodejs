package system.basic

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import common.JsHelpers
import common.WskTestHelpers

@RunWith(classOf[JUnitRunner])
class WskUnicodeIBMNodeTests extends WskUnicodeTests with WskTestHelpers with JsHelpers {

  override lazy val actionKind = "nodejs-ibm:8"
  override lazy val actionSource = "unicode.js"

}
