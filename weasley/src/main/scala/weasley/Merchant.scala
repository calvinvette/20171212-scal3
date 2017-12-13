package weasley

import java.time.LocalDate

import scala.runtime.ScalaRunTime

case class Merchant(
                     name: String,
                     registrationDate: LocalDate
                   ) extends Location {
  override def toString: String = ScalaRunTime._toString(this) + appendLocationToString
}