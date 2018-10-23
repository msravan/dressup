package dressup

import dressup.util.Temperature
import org.scalatest.FlatSpec

class PutOnJacketSpec extends FlatSpec{
  "A person" should "not wear a jacket twice in COLD weather" in {
    var itemAdd = new Item
    itemAdd.setTemperature(Temperature.COLD)
    itemAdd.jacket = true
    itemAdd = new PutOnJacket(itemAdd).doIt
    assert(itemAdd.getDescription.takeRight(4).matches("fail"))
  }
  "A person" should  "not wear a jacket in HOT weather" in {
    var itemAdd = new Item
    itemAdd.setTemperature(Temperature.HOT)
    itemAdd = new PutOnJacket(itemAdd).doIt
    assert(itemAdd.getDescription.takeRight(4).matches("fail"))
  }
  "A person" should  "fail when he don't wear a shirt before a jacket in COLD weather" in {
    var itemAdd = new Item
    itemAdd.shirt = false
    itemAdd.setTemperature(Temperature.COLD)
    itemAdd = new PutOnJacket(itemAdd).doIt
    assert(itemAdd.getDescription.takeRight(4).matches("fail"))
  }
  "A person" should  "wear a shirt before a jacket in COLD weather" in {
    var itemAdd = new Item
    itemAdd.shirt = true
    itemAdd.setTemperature(Temperature.COLD)
    itemAdd = new PutOnJacket(itemAdd).doIt
    assert(!itemAdd.getDescription.contains("fail") && itemAdd.getDescription.contains("jacket"))
  }
  "A person" should "wear a jacket before leaving house in COLD weather" in {
    var itemAdd = new Item
    itemAdd.setTemperature(Temperature.COLD)
    itemAdd.footwear = true
    itemAdd.headwear = true
    itemAdd.socks = true
    itemAdd.pants = true
    itemAdd.shirt = true
    itemAdd = new PutOnJacket(itemAdd).doIt
    assert(!itemAdd.getDescription.contains("fail") && itemAdd.getDescription.contains("jacket"))
  }
}
