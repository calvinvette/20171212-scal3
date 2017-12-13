package weasley

import java.time._

class AmericanExpressCard(cardNumber: String, expirationDate: YearMonth, billingZip: Int, nameOnCard: String, cardType: String = "AMEX")
  extends CreditCard(cardNumber, expirationDate, billingZip, nameOnCard, cardType)