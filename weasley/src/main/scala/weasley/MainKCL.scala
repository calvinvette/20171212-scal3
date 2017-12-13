package weasley

import java.time._

object MainKCL {

  // Boston, MA to Hartford, CT - 1hr, 37min
  // 42.361409, -71.055076 - Boston, MA
  // 42.267978, -71.555928 - Westborough, MA        (43-54 min)
  // 42.126226, -72.066642 - Sturbridge, MA        (37-39 min)
  // 41.839711, -72.465046 - Vernon, CT                (31-57 min)
  // 41.769578, -72.682408 - Hartford, CT                (16-20 min)

  def main(args: Array[String]): Unit = {
    val now = LocalDateTime.now()

    val cust = new Customer("Harry", "Potter", "+44 0206 961-9301", "harry.potter@hogwarts.ac.uk")
    // Apply the location
    cust.city = "San Francisco"
    cust.state = "CA"
    cust.country = "US"

    // Boston, MA, start time
    val loc1 = new Location {
      latitude = 42.361409
      longitude = -71.055076
    }
    val ts1 = now
    val kcl1 = new KnownCustomerLocation(cust)
    kcl1.latitude = loc1.latitude
    kcl1.longitude = loc1.longitude
    kcl1.city = "Boston"
    kcl1.state = "MA"
    kcl1.country = "US"
    kcl1.timestamp = ts1

    // Westborough
    val loc2 = new Location {
      latitude = 42.267978
      longitude = -71.555928
    }
    val ts2 = now.plusMinutes(50)
    val kcl2 = new KnownCustomerLocation(cust)
    kcl2.latitude = loc2.latitude
    kcl2.longitude = loc2.longitude
    kcl2.city = "Westborough"
    kcl2.state = "MA"
    kcl2.country = "US"
    kcl2.timestamp = ts2

    // Sturbridge
    val loc3 = new Location {
      latitude = 42.126226
      longitude = -72.066642
    }
    val ts3 = ts2.plusMinutes(37)
    val kcl3 = new KnownCustomerLocation(cust)
    kcl3.latitude = loc3.latitude
    kcl3.longitude = loc3.longitude
    kcl3.city = "Sturbridge"
    kcl3.state = "MA"
    kcl3.country = "US"
    kcl3.timestamp = ts3

    // Vernon, CT
    val loc4 = new Location {
      latitude = 41.839711
      longitude = -72.465046
    }
    val ts4 = ts3.plusMinutes(38)
    val kcl4 = new KnownCustomerLocation(cust)
    kcl4.latitude = loc4.latitude
    kcl4.longitude = loc4.longitude
    kcl4.city = "Vernon"
    kcl4.state = "CT"
    kcl4.country = "US"
    kcl4.timestamp = ts4

    // Hartford, CT
    val loc5 = new Location {
      latitude = 41.769578
      longitude = -72.682408
    }
    val ts5 = ts4.plusMinutes(16)
    val kcl5 = new KnownCustomerLocation(cust)
    kcl5.latitude = loc5.latitude
    kcl5.longitude = loc5.longitude
    kcl5.city = "Hartford"
    kcl5.state = "CT"
    kcl5.country = "US"
    kcl5.timestamp = ts5

    println(kcl1)
    println(kcl2)
    println(kcl3)
    println(kcl4)
    println(kcl5)
  }
}