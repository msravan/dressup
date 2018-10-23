package dressup

import dressup.util.Temperature
import org.scalatest.FlatSpec

class PutOnShirtSpec extends FlatSpec{

  "A person" should "not dress up with shirt twice" in {
    var itemAdd = new Item
    itemAdd.shirt = true
    itemAdd = new PutOnShirt(itemAdd).doIt
    assert(itemAdd.getDescription.takeRight(4).matches("fail"))
  }
  "A person" should "wear shirt before leaving house in COLD weather" in {
    var itemAdd = new Item
    itemAdd.setTemperature(Temperature.COLD)
    itemAdd.footwear = true
    itemAdd.headwear = true
    itemAdd.socks = true
    itemAdd.pants = true
    itemAdd.jacket = true
    itemAdd = new PutOnShirt(itemAdd).doIt
    assert(!itemAdd.getDescription.contains("fail") && itemAdd.getDescription.contains("shirt"))
  }

  "A person" should "wear shirt before leaving house in HOT weather" in {
    var itemAdd = new Item
    itemAdd.setTemperature(Temperature.HOT)
    itemAdd.footwear = true
    itemAdd.headwear = true
    itemAdd.pants = true
    itemAdd = new PutOnShirt(itemAdd).doIt
    assert(!itemAdd.getDescription.contains("fail") && itemAdd.getDescription.contains("shirt"))
  }
}
