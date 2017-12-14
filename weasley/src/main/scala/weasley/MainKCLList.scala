package weasley

import java.time._

import scala.collection.mutable

object MainKCLList {

  // Boston, MA to Hartford, CT - 1hr, 37min
  // 42.361409, -71.055076 - Boston, MA
  // 42.267978, -71.555928 - Westborough, MA        (43-54 min)
  // 42.126226, -72.066642 - Sturbridge, MA        (37-39 min)
  // 41.839711, -72.465046 - Vernon, CT                (31-57 min)
  // 41.769578, -72.682408 - Hartford, CT                (16-20 min)

  val radiusOfEarth = 6371

  def haversine(latitude1: Double, longitude1: Double, latitude2: Double, longitude2: Double): Double = {
    val diffLat = Math.toRadians(latitude2 - latitude1)
    val diffLong = Math.toRadians(longitude2 - longitude2)
    val a =
      Math.sin(diffLat/2) * Math.sin(diffLat/2) +
        Math.cos(Math.toRadians(latitude1)) * Math.cos(Math.toRadians(latitude2)) *
          Math.sin(diffLong/2) * Math.sin(diffLong/2)
    val c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a))
    val d = radiusOfEarth * c
    d
  }

  def main(args: Array[String]): Unit = {
    val now = LocalDateTime.now()

    val cust = new Customer("Harry", "Potter", "+44 0206 961-9301", "harry.potter@hogwarts.ac.uk")
    // Apply the location
    cust.city = "San Francisco"
    cust.state = "CA"
    cust.country = "US"

    val kclArray = new Array[KnownCustomerLocation](5)

    // Boston, MA, start time
    kclArray(0) = new KnownCustomerLocation(cust)
    kclArray(0).latitude = 42.361409
    kclArray(0).longitude = -71.055076
    kclArray(0).city = "Boston"
    kclArray(0).state = "MA"
    kclArray(0).country = "US"
    kclArray(0).timestamp = now

    // Westborough
    kclArray(1) = new KnownCustomerLocation(cust)
    kclArray(1).latitude = 42.267978
    kclArray(1).longitude = -71.555928
    kclArray(1).city = "Westborough"
    kclArray(1).state = "MA"
    kclArray(1).country = "US"
    kclArray(1).timestamp = kclArray(0).timestamp.plusMinutes(50)

    // Sturbridge
    kclArray(2) = new KnownCustomerLocation(cust)
    kclArray(2).latitude = 42.126226
    kclArray(2).longitude = -72.066642
    kclArray(2).city = "Sturbridge"
    kclArray(2).state = "MA"
    kclArray(2).country = "US"
    kclArray(2).timestamp = kclArray(1).timestamp.plusMinutes(37)

    // Vernon, CT
    kclArray(3) = new KnownCustomerLocation(cust)
    kclArray(3).latitude = 41.839711
    kclArray(3).longitude = -72.465046
    kclArray(3).city = "Vernon"
    kclArray(3).state = "CT"
    kclArray(3).country = "US"
    kclArray(3).timestamp = kclArray(2).timestamp.plusMinutes(38)

    // Hartford, CT
    kclArray(4) = new KnownCustomerLocation(cust)
    kclArray(4).latitude = 41.769578
    kclArray(4).longitude = -72.682408
    kclArray(4).city = "Hartford"
    kclArray(4).state = "CT"
    kclArray(4).country = "US"
    kclArray(4).timestamp = kclArray(3).timestamp.plusMinutes(16)

    //    for (kcl <- kclArray) {
    //      println(kcl)
    //    }

    val kclList = List.tabulate(kclArray.length)(n => kclArray(n))

    println(kclList)

    for (kcl <- kclList) println(kcl)

    val anotherKCL = new KnownCustomerLocation(cust)

    val biggerList = kclList ::: List(anotherKCL)

    println("Original List is unmodified:")
    for (kcl <- kclList) println(kcl)

    println("biggerList adds one more KCL:")
    for (kcl <- biggerList) println(kcl)

    anotherKCL.latitude = 43.5
    anotherKCL.longitude = -83.5
    println("Did the last KCL in biggerList change?")
    for (kcl <- biggerList) println(kcl)

    val distances = scala.collection.mutable.LinkedList.fill(biggerList.size - 1)(0.0)
    println(distances)
    for (i <- 0 until (biggerList.size - 1))
      distances(i) = haversine(biggerList(i).latitude, biggerList(i).longitude, biggerList(i+1).latitude, biggerList(i+1).longitude)

    println(distances)

    // val distancesTravelled = scala.collection.mutable.LinkedList.fill(biggerList.size)(0.0)
    val distancesTravelled = scala.collection.mutable.MutableList.fill(biggerList.size)(0.0)
    println(distancesTravelled)
    for (i <- 1 until (biggerList.size))
      distancesTravelled(i) = haversine(biggerList(i - 1).latitude, biggerList(i - 1).longitude, biggerList(i).latitude, biggerList(i).longitude)

    println(distancesTravelled)

    val travelLog = biggerList zip distancesTravelled
    for (entry <- travelLog) println(entry._1 + "\t" + entry._2)

    for ((key, value) <- travelLog) println(key + "\t" + value)

    println("Total distance travelled: " + travelLog.map(_._2).sum)
  }
}