package demo

trait Trait2 {
  private var _name: String = "TRAIT2"
  def name = _name
  def name_= (name: String): Unit = _name = name
}
