package dressup

import dressup.util.{CustomFail, Temperature}

class PutOnShirt(item: Item) extends Item {

  def doIt(): Item = {
    if (item.shirt) item.description = CustomFail.failPrint(item.getDescription)
    else {
      item.shirt = true
      item.getTemperature match {
        case Temperature.HOT => {
          item.description = item.getDescription + ", shirt"
        }
        case Temperature.COLD => {
          item.description = item.getDescription + ", shirt"
        }
      }
    }
    this.item
  }
}