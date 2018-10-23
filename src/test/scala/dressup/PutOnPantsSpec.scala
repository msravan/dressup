package dressup

import dressup.util.Temperature
import org.scalatest.FlatSpec

class PutOnPantsSpec extends FlatSpec{
  "A person" should "not dress up with pants twice" in {
    var itemAdd = new Item
    itemAdd.pants = true
    itemAdd = new PutOnPants(itemAdd).doIt
    assert(itemAdd.getDescription.takeRight(4).matches("fail"))
  }
  "A person" should "wear pants before leaving house in COLD weather" in {
    var itemAdd = new Item
    itemAdd.setTemperature(Temperature.COLD)
    itemAdd.footwear = true
    itemAdd.headwear = true
    itemAdd.socks = true
    itemAdd.shirt = true
    itemAdd.jacket = true
    itemAdd = new PutOnPants(itemAdd).doIt
    assert(!itemAdd.getDescription.contains("fail") && itemAdd.getDescription.contains("pants"))
  }

  "A person" should "wear shorts before leaving house in HOT weather" in {
    var itemAdd = new Item
    itemAdd.setTemperature(Temperature.HOT)
    itemAdd.footwear = true
    itemAdd.headwear = true
    itemAdd.shirt = true
    itemAdd = new PutOnPants(itemAdd).doIt
    assert(!itemAdd.getDescription.contains("fail")&& itemAdd.getDescription.contains("shorts"))
  }
}
