package dressup

import dressup.util.Temperature
import org.scalatest.FlatSpec

class PutOnHeawearSpec extends FlatSpec{
  "A person" should "not wear a headwear twice in HOT weather" in {
    var itemAdd = new Item
    itemAdd.setTemperature(Temperature.HOT)
    itemAdd.headwear = true
    itemAdd = new PutOnHeadwear(itemAdd).doIt
    assert(itemAdd.getDescription.takeRight(4).matches("fail"))
  }
  "A person" should "not wear a headwear twice in COLD weather" in {
    var itemAdd = new Item
    itemAdd.setTemperature(Temperature.COLD)
    itemAdd.headwear = true
    itemAdd = new PutOnHeadwear(itemAdd).doIt
    assert(itemAdd.getDescription.takeRight(4).matches("fail"))
  }

  "A person" should  "fail when he don't wear a shirt before a headwear in COLD weather" in {
    var itemAdd = new Item
    itemAdd.shirt = false
    itemAdd.setTemperature(Temperature.COLD)
    itemAdd = new PutOnHeadwear(itemAdd).doIt
    assert(itemAdd.getDescription.takeRight(4).matches("fail"))
  }

  "A person" should  "fail when he don't wear a shirt before a headwear in HOT weather" in {
    var itemAdd = new Item
    itemAdd.shirt = false
    itemAdd.setTemperature(Temperature.HOT)
    itemAdd = new PutOnHeadwear(itemAdd).doIt
    assert(itemAdd.getDescription.takeRight(4).matches("fail"))
  }
  "A person" should  "wear a shirt before a headwear hat in COLD weather" in {
    var itemAdd = new Item
    itemAdd.shirt = true
    itemAdd.setTemperature(Temperature.COLD)
    itemAdd = new PutOnHeadwear(itemAdd).doIt
    assert(!itemAdd.getDescription.contains("fail") && itemAdd.getDescription.contains("hat"))
  }
  "A person" should  "wear a shirt before a headwear sunglasses in HOT weather" in {
    var itemAdd = new Item
    itemAdd.shirt = true
    itemAdd.setTemperature(Temperature.HOT)
    itemAdd = new PutOnHeadwear(itemAdd).doIt
    assert(!itemAdd.getDescription.contains("fail") && itemAdd.getDescription.contains("sunglasses"))
  }
  "A person" should "wear a headwear before leaving house in COLD weather" in {
    var itemAdd = new Item
    itemAdd.setTemperature(Temperature.COLD)
    itemAdd.footwear = true
    itemAdd.jacket = true
    itemAdd.socks = true
    itemAdd.pants = true
    itemAdd.shirt = true
    itemAdd = new PutOnHeadwear(itemAdd).doIt
    assert(!itemAdd.getDescription.contains("fail") && itemAdd.getDescription.contains("hat"))
  }
  "A person" should "wear a headwear before leaving house in HOT weather" in {
    var itemAdd = new Item
    itemAdd.setTemperature(Temperature.HOT)
    itemAdd.footwear = true
    itemAdd.pants = true
    itemAdd.shirt = true
    itemAdd = new PutOnHeadwear(itemAdd).doIt
    assert(!itemAdd.getDescription.contains("fail") && itemAdd.getDescription.contains("sunglasses"))
  }
}
