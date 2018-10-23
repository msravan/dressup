package dressup

import org.scalatest.FlatSpec

class RemovePajamasSpec extends FlatSpec{
  "A person" should "remove pajamas to dressup" in {
    var itemAdd = new Item
    itemAdd = new RemovePajamas(itemAdd).doIt()
    assert(itemAdd.getDescription.matches("Removing PJs"))
  }
}
