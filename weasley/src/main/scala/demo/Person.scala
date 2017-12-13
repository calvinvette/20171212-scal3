package demo

case class Person(
                   override var name: String = "PersonName"
                 ) extends Trait1 with Trait2 with Trait3 {

}
