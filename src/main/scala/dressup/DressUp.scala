package dressup

import dressup.util.Temperature
import dressup.util.Temperature.{COLD, Temperature}

import scala.collection.mutable
import scala.util.control.Breaks
import scala.util.control.Breaks._

class DressUp {

  def getTemperature(head: Any): Temperature.Value = {
    head.asInstanceOf[String].toLowerCase match {
      case "hot" => Temperature.HOT
      case "cold" => Temperature.COLD
      case _ => Temperature.COLD //taking cold as a default weather
    }
  }

  def dressUp(args: Array[String]): Item = {
    val temperature = getTemperature(args.head)
    val commands = args.tail
    val loop = new Breaks;
    var itemAdd = new Item

    def checkBreak(itemAdd: Item) = {
      if (itemAdd.getDescription.takeRight(4) == "fail") {
        loop.break
      }
    }

    itemAdd.setTemperature(temperature)
    commands.head match {
      case "8" => {
        loop.breakable {
          commands.foreach(command => {
            command match {
              case "1" => {
                itemAdd = new PutOnFootwear(itemAdd).doIt
                checkBreak(itemAdd)
              }
              case "2" => {
                itemAdd = new PutOnHeadwear(itemAdd).doIt
                checkBreak(itemAdd)
              }
              case "3" => {
                itemAdd = new PutOnSocks(itemAdd).doIt
                checkBreak(itemAdd)
              }
              case "4" => {
                itemAdd = new PutOnShirt(itemAdd).doIt
                checkBreak(itemAdd)
              }
              case "5" => {
                itemAdd = new PutOnJacket(itemAdd).doIt
                checkBreak(itemAdd)
              }
              case "6" => {
                itemAdd = new PutOnPants(itemAdd).doIt
                checkBreak(itemAdd)
              }
              case "7" => {
                itemAdd = new LeaveHouse(itemAdd).doIt
                checkBreak(itemAdd)
              }
              case "8" => {
                itemAdd = new RemovePajamas(itemAdd).doIt
              }
            }
          })

        }
      }
      case _ => itemAdd.description = "fail"
    }
    itemAdd
  }
}
