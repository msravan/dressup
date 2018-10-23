package dressup

import dressup.util.Temperature.Temperature

class Item {

  var footwear: Boolean = false
  var headwear: Boolean = false
  var socks: Boolean = false
  var shirt: Boolean = false
  var jacket: Boolean = false
  var pants: Boolean = false

  var temperature: Temperature = _
  var description = ""

  def setTemperature(temperature: Temperature) = {
    this.temperature = temperature
  }

  def getTemperature: Temperature = this.temperature

  def getDescription: String = this.description

}
