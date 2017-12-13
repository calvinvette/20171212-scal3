package weasley

import java.time.LocalDateTime

import scala.runtime.ScalaRunTime

case class Transaction(
                        creditCard: CreditCard,
                        authorizationAmount: Double,
                        settlementAmount: Double,
                        transactionDate: LocalDateTime,
                        postingDate: LocalDateTime,
                        merchant: Merchant,
                        cardPresent: Boolean
                      ) extends Location {
  override def toString: String = ScalaRunTime._toString(this) + appendLocationToString
}