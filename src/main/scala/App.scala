import dressup.DressUp

object App {
  def main(args: Array[String]) {
    val person = new DressUp
    val item =person.dressUp(args)
    println(item.getDescription)
  }
}
