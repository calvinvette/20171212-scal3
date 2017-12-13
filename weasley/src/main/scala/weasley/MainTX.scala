package weasley

import java.time._

import weasley.CreditCard._

object MainTX {

  def main(args: Array[String]): Unit = {
    val amex = createCard("3111-111111-11111", YearMonth.of(2018, Month.APRIL), 12345, "Harry J. Potter")
    val bestBuy1 = Merchant("Best Buy #1", LocalDate.of(2015, Month.APRIL, 13))

    // Apply the location
    bestBuy1.city = "Burnsville"
    bestBuy1.state = "MN"
    bestBuy1.country = "US"

    // We're using named parameters below rather than positional parameters for better readability
    val tx1 = Transaction(
      creditCard = amex,
      authorizationAmount = 19.99,
      settlementAmount = 19.99,
      transactionDate = LocalDateTime.now(),
      postingDate = LocalDateTime.now(),
      merchant = bestBuy1,
      cardPresent = true
    )

    // Apply the location
    tx1.city = bestBuy1.city
    tx1.state = bestBuy1.state
    tx1.country = bestBuy1.country

    println(tx1)

    val cust = new Customer("Harry", "Potter", "+44 0206 961-9301", "harry.potter@hogwarts.ac.uk")
    // Apply the location
    cust.city = "San Francisco"
    cust.state = "CA"
    cust.country = "US"

    println(cust)
  }
}