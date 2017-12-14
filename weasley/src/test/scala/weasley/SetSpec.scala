import org.scalatest.FlatSpec

class SetSpec extends FlatSpec {

  "An empty Set" should "have size 1" in {
    assert(Set.empty.size == 0)
  }

  it should "produce NoSuchElementException when head is invoked" in {
    assertThrows[NoSuchElementException] {
      Set.empty.head
    }
  }
}