package demo

trait Trait1 {
  private var _name: String = "TRAIT1"
  def name: String = return _name
  def name_= (name: String): Unit = _name = name
}
