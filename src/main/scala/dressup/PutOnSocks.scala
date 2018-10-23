package dressup

import dressup.util.{CustomFail, Temperature}

class PutOnSocks(item: Item) extends Item {

  def doIt(): Item = {
    if (item.socks) item.description = CustomFail.failPrint(item.getDescription)
    else {
      item.socks = true
      item.getTemperature match {
        case Temperature.HOT => {
          item.description = CustomFail.failPrint(item.getDescription)
        }
        case Temperature.COLD => {
          item.description = item.getDescription + ", socks"
        }
      }
    }
    this.item
  }
}