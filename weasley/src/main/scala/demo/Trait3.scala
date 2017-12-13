package demo

trait Trait3 {
  private var _name: String = "TRAIT3"
  def name = _name
  def name_= (name: String): Unit = _name = name
}
