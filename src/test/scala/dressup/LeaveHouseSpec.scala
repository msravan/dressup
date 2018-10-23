package dressup

import dressup.util.Temperature
import org.scalatest.FlatSpec

class LeaveHouseSpec extends FlatSpec {
  "A person" should "wear headwear,socks,footwear,pants,shirt,jacket in COLD weather before leaving house" in {
    var itemAdd = new Item
    itemAdd.headwear = true
    itemAdd.footwear = true
    itemAdd.socks = true
    itemAdd.pants = true
    itemAdd.jacket = true
    itemAdd.shirt = true
    itemAdd.setTemperature(Temperature.COLD)
    itemAdd = new LeaveHouse(itemAdd).doIt
    assert(!itemAdd.getDescription.contains("fail") && itemAdd.getDescription.endsWith("leaving house"))
  }
  "A person" should "wear headwear,footwear,pants,shirt and not wear socks,jacket in HOT weather before leaving house" in {
    var itemAdd = new Item
    itemAdd.headwear = true
    itemAdd.footwear = true
    itemAdd.socks = false
    itemAdd.pants = true
    itemAdd.jacket = false
    itemAdd.shirt = true
    itemAdd.setTemperature(Temperature.HOT)
    itemAdd = new LeaveHouse(itemAdd).doIt
    assert(!itemAdd.getDescription.contains("fail") && itemAdd.getDescription.endsWith("leaving house"))
  }
}
