
// "class" is a blueprint for an instance
// You don't use it directly - you instantiate one using "new"
// All properties are unique per instance (each instance gets its own copy)

class HelloIntelliJ {
  val myName: String = "Hermione";

  def mymain(args: Array[String]): Unit = {
    println(myName)
  }

}


// a Singleton instance is created with the myName
// Reference using HelloIntelliJ.myName
//
object HelloIntelliJ {
  val myName: String = "Harry";

  def main(args: Array[String]): Unit = {
    println(myName)
    val myInstance = new HelloIntelliJ
    println(myInstance.myName);
    myInstance.mymain(args)
  }
}

