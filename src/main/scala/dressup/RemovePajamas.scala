package dressup

class RemovePajamas(item: Item) extends Item {
  item.description = "Removing PJs"

  def doIt(): Item = {
    this.item
  }
}