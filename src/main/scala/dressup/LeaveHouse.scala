package dressup

import dressup.util.{CustomFail, Temperature}

class LeaveHouse (item: Item) extends Item {
def doIt: Item ={

  item.getTemperature match {
    case Temperature.HOT => {
      if(!item.socks && item.shirt && !item.jacket && item.headwear && item.pants && item.footwear) {
        item.description = item.getDescription + ", leaving house"
      }
      else
        item.description =  CustomFail.failPrint(item.getDescription)
    }
    case Temperature.COLD => {
      if(item.socks && item.shirt && item.jacket && item.headwear && item.pants && item.footwear)
        item.description =  item.getDescription + ", leaving house"
      else
        item.description =  CustomFail.failPrint(item.getDescription)
    }
  }
  this.item
 }
}