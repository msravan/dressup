package dressup

import dressup.util.{CustomFail, Temperature}

class PutOnHeadwear(item: Item) extends Item {

  def doIt(): Item ={
    if(item.headwear) item.description = CustomFail.failPrint(item.getDescription)
    if(item.shirt) {
      item.headwear = true
      item.getTemperature match {
        case Temperature.HOT => {
          item.description = item.getDescription + ", sunglasses"
        }
        case Temperature.COLD => {
          item.description = item.getDescription + ", hat"
        }
      }
    }
    else item.description =  CustomFail.failPrint(item.getDescription)
    this.item
  }
}