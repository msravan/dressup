package dressup

import dressup.util.{CustomFail, Temperature}

class PutOnPants(item: Item) extends Item {

  def doIt(): Item = {
    if (item.pants) item.description = CustomFail.failPrint(item.getDescription)
    else {
      item.pants = true
      item.getTemperature match {
        case Temperature.HOT => {
          item.description = item.getDescription + ", shorts"
        }
        case Temperature.COLD => {
          item.description = item.getDescription + ", pants"
        }
      }
    }
    this.item
  }
}