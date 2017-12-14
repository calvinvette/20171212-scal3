package weasley

import org.scalatest.FlatSpec

class HaversineSpec extends FlatSpec {

  "Distance from Boston to Hartford" should "be about 93 miles (linear distance)" in {
    // Boston: 42.3572844,-71.0788262
    // Hartford: 41.7408111,-72.7053177
    val dist = MainKCLList.haversine(42.3572844, -71.0788262, 41.7408111, -72.7053177)
    assert(dist > 90 * 1.6 && dist < 100 * 1.6)
  }
}