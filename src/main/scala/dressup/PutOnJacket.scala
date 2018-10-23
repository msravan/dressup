package dressup

import dressup.util.{CustomFail, Temperature}

class PutOnJacket(item: Item) extends Item {

  def doIt(): Item ={
    if(item.jacket) item.description = CustomFail.failPrint(item.getDescription)
    else
    {
      if(item.shirt) {
        item.jacket = true
        item.getTemperature match {
          case Temperature.HOT => {
            item.description =  CustomFail.failPrint(item.getDescription)
          }
          case Temperature.COLD => {
            item.description = item.getDescription + ", jacket"
          }
        }
      }
      else item.description =  CustomFail.failPrint(item.getDescription)
    }
    this.item
  }
}