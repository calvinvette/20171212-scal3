package weasley

import java.time.{LocalDate, LocalDateTime, LocalTime}

import scala.runtime.ScalaRunTime

case class KnownCustomerLocation(customer: Customer) extends Location with weasley.TimeStamp {
  override def toString: String = ScalaRunTime._toString(this) + appendLocationToString + appendTimeStampToString
}

object KnownCustomerLocation {
  def apply(customer: Customer, location: Location, ts: weasley.TimeStamp): KnownCustomerLocation = {
    val kcl = new KnownCustomerLocation(customer)
    kcl.longitude = location.longitude
    kcl.latitude = location.latitude
    kcl.city = location.city
    kcl.state = location.state
    kcl.country = location.country
    kcl.postalCode = location.postalCode
    kcl.timestamp = ts.timestamp
    kcl
  }

  def apply(customer: Customer): KnownCustomerLocation = {
    new KnownCustomerLocation(customer)
  }

  def apply(customer: Customer, location: Location): KnownCustomerLocation = {
    val kcl = new KnownCustomerLocation(customer)
    kcl.longitude = location.longitude
    kcl.latitude = location.latitude
    kcl.city = location.city
    kcl.state = location.state
    kcl.country = location.country
    kcl.postalCode = location.postalCode
    kcl.timestamp = LocalDateTime.now
    kcl
  }
}