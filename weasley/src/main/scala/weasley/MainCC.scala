package weasley

import java.time._
import CreditCard._

object MainCC {

  def main(args: Array[String]): Unit = {
    println("# of cards: " + cardCount)
    val amex = new AmericanExpressCard("3111-111111-11111", YearMonth.of(2018, Month.APRIL), 12345, "Harry J. Potter")
    println(amex)
    println("# of cards: " + cardCount)
    println(cardTypeFromNumber(amex.cardNumber))
    for (i <- 1 until 4) {
      val anotherCC = inputCard()
      println(anotherCC)
      println("Is it expired? " + isExpired(anotherCC))
      println("# of cards: " + cardCount)
    }
  }
}