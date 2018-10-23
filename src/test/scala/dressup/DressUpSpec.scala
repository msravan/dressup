package dressup

import dressup.util.Temperature
import org.scalatest.FlatSpec

class DressUpSpec extends FlatSpec{

  "A temperature" should "be HOT of Temperature type for the inputs Hot, hot, HOT, hOT," in {
    val dressUp = new DressUp
    assert(dressUp.getTemperature("hot")==Temperature.HOT)
    assert(dressUp.getTemperature("Hot")==Temperature.HOT)
    assert(dressUp.getTemperature("HOT")==Temperature.HOT)
    assert(dressUp.getTemperature("hOT")==Temperature.HOT)
  }
  "A temperature" should "be COLD of Temperature type for the inputs Cold, cold, COLD, cOLD," in {
    val dressUp = new DressUp
    assert(dressUp.getTemperature("Cold")==Temperature.COLD)
    assert(dressUp.getTemperature("cold")==Temperature.COLD)
    assert(dressUp.getTemperature("COLD")==Temperature.COLD)
    assert(dressUp.getTemperature("cOLD")==Temperature.COLD)
  }
  "Dressup" should "pass for the input 'HOT 8, 6, 4, 2, 1, 7' " in {
    val dressUp = new DressUp
    val item = dressUp.dressUp(Array("HOT", "8", "6", "4", "2", "1", "7"))
    assert(item.getDescription.matches("Removing PJs, shorts, shirt, sunglasses, sandals, leaving house"))
  }
  "Dressup" should "pass for the input 'COLD 8, 6, 3, 4, 2, 5, 1, 7' " in {
    val dressUp = new DressUp
    val item = dressUp.dressUp(Array("COLD", "8", "6", "3", "4", "2", "5", "1", "7"))
    assert(item.getDescription.matches("Removing PJs, pants, socks, shirt, hat, jacket, boots, leaving house"))
  }
  "Dressup" should "fail for the input 'HOT 8, 6, 6' " in {
    val dressUp = new DressUp
    val item = dressUp.dressUp(Array("HOT", "8", "6", "6"))
    assert(item.getDescription.matches("Removing PJs, shorts, fail"))
  }
  "Dressup" should "fail for the input 'HOT 8, 6, 3' " in {
    val dressUp = new DressUp
    val item = dressUp.dressUp(Array("HOT", "8", "6", "3"))
    assert(item.getDescription.matches("Removing PJs, shorts, fail"))
  }

  "Dressup" should "fail for the input 'COLD 8, 6, 3, 4, 2, 5, 7' " in {
    val dressUp = new DressUp
    val item = dressUp.dressUp(Array("COLD", "8", "6", "3", "4", "2", "5", "7"))
    assert(item.getDescription.matches("Removing PJs, pants, socks, shirt, hat, jacket, fail"))
  }
  "Dressup" should "pass for the input 'COLD 6' " in {
    val dressUp = new DressUp
    val item = dressUp.dressUp(Array("COLD", "6"))
    assert(item.getDescription.matches("fail"))
  }
}
