package dressup

import dressup.util.Temperature
import org.scalatest.{FlatSpec, Matchers}

class PutOnSocksSpec extends FlatSpec with Matchers {

  "A person" should "not wear a socks in HOT weather" in {
    var itemAdd = new Item
    itemAdd.setTemperature(Temperature.HOT)
    itemAdd = new PutOnSocks(itemAdd).doIt
    assert(itemAdd.getDescription.takeRight(4).matches("fail"))
  }
  "A person" should "not dress up with socks twice" in {
    var itemAdd = new Item
    itemAdd.socks = true
    itemAdd = new PutOnSocks(itemAdd).doIt
    assert(itemAdd.getDescription.takeRight(4).matches("fail"))
  }
  "A person" should "wear socks before leaving house in COLD weather" in {
    var itemAdd = new Item
    itemAdd.setTemperature(Temperature.COLD)
    itemAdd.footwear = true
    itemAdd.headwear = true
    itemAdd.shirt = true
    itemAdd.pants = true
    itemAdd.jacket = true
    itemAdd = new PutOnSocks(itemAdd).doIt
    assert(!itemAdd.getDescription.contains("fail"))
  }
}