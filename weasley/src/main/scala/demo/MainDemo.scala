package demo

object MainDemo {
  def main(args: Array[String]): Unit = {
//    val p1 = Person("Harry Potter")
    val p1 = Person()
    p1.name = "Harry Potter"
    println(p1.name)
  }
}
