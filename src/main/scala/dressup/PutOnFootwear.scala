package dressup

import dressup.util.{CustomFail, Temperature}

class PutOnFootwear(item: Item) extends Item {

  def doIt(): Item = {
    if (item.footwear) item.description = CustomFail.failPrint(item.getDescription)
    else {
      item.getTemperature match {
        case Temperature.HOT => {
          if (item.pants) {
            item.footwear = true
            item.description = item.getDescription + ", sandals"
          }
          else item.description = CustomFail.failPrint(item.getDescription)
        }
        case Temperature.COLD => {
          if (item.pants && item.socks) {
            item.footwear = true
            item.description = item.getDescription + ", boots"
          }
          else item.description = CustomFail.failPrint(item.getDescription)
        }
      }
    }
    this.item
  }
}