package dressup

import dressup.util.Temperature
import org.scalatest.FlatSpec

class PutOnFootwearSpec extends FlatSpec{
  "A person" should "not wear a footwear twice in HOT weather" in {
    var itemAdd = new Item
    itemAdd.setTemperature(Temperature.HOT)
    itemAdd.footwear = true
    itemAdd = new PutOnFootwear(itemAdd).doIt
    assert(itemAdd.getDescription.takeRight(4).matches("fail"))
  }
  "A person" should "not wear a footwear twice in COLD weather" in {
    var itemAdd = new Item
    itemAdd.setTemperature(Temperature.COLD)
    itemAdd.footwear = true
    itemAdd = new PutOnFootwear(itemAdd).doIt
    assert(itemAdd.getDescription.takeRight(4).matches("fail"))
  }
  "A person" should  "fail when he don't wear a socks before a headwear in COLD weather" in {
    var itemAdd = new Item
    itemAdd.socks = false
    itemAdd.setTemperature(Temperature.COLD)
    itemAdd = new PutOnFootwear(itemAdd).doIt
    assert(itemAdd.getDescription.takeRight(4).matches("fail"))
  }
  "A person" should  "fail when he don't wear pants before a headwear in COLD weather" in {
    var itemAdd = new Item
    itemAdd.pants = false
    itemAdd.setTemperature(Temperature.COLD)
    itemAdd = new PutOnFootwear(itemAdd).doIt
    assert(itemAdd.getDescription.takeRight(4).matches("fail"))
  }
  "A person" should  "fail when he don't wear pants before a headwear in HOT weather" in {
    var itemAdd = new Item
    itemAdd.pants = false
    itemAdd.setTemperature(Temperature.HOT)
    itemAdd = new PutOnFootwear(itemAdd).doIt
    assert(itemAdd.getDescription.takeRight(4).matches("fail"))
  }
  "A person" should  "wear a socks and pants before a headwear in COLD weather" in {
    var itemAdd = new Item
    itemAdd.socks = true
    itemAdd.pants = true
    itemAdd.setTemperature(Temperature.COLD)
    itemAdd = new PutOnFootwear(itemAdd).doIt
    assert(!itemAdd.getDescription.contains("fail") && itemAdd.getDescription.contains("boots"))
  }
  "A person" should  "wear pants before a footwear in HOT weather" in {
    var itemAdd = new Item
    itemAdd.socks = true
    itemAdd.pants = true
    itemAdd.setTemperature(Temperature.HOT)
    itemAdd = new PutOnFootwear(itemAdd).doIt
    assert(!itemAdd.getDescription.contains("fail") && itemAdd.getDescription.contains("sandals"))
  }
  "A person" should "wear a footwear before leaving house in COLD weather" in {
    var itemAdd = new Item
    itemAdd.setTemperature(Temperature.COLD)
    itemAdd.headwear = true
    itemAdd.jacket = true
    itemAdd.socks = true
    itemAdd.pants = true
    itemAdd.shirt = true
    itemAdd = new PutOnFootwear(itemAdd).doIt
    assert(!itemAdd.getDescription.contains("fail") && itemAdd.getDescription.contains("boots"))
  }
  "A person" should "wear a footwear before leaving house in HOT weather" in {
    var itemAdd = new Item
    itemAdd.setTemperature(Temperature.HOT)
    itemAdd.headwear = true
    itemAdd.pants = true
    itemAdd.shirt = true
    itemAdd = new PutOnFootwear(itemAdd).doIt
    assert(!itemAdd.getDescription.contains("fail") && itemAdd.getDescription.contains("sandals"))
  }
}
