package dressup.util

import org.scalatest.FlatSpec

class CustomFailSpec extends FlatSpec{

  "A custom message" should "be printed before ', fail' " in {
    val customMessage = "this is a test"
    val customFail = CustomFail.failPrint(customMessage)
    assert(customFail == customMessage+", fail")
  }
}
