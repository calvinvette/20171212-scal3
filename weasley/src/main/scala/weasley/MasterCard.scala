package weasley

import java.time._

class MasterCard(cardNumber: String, expirationDate: YearMonth, billingZip: Int, nameOnCard: String, cardType: String = "MASTERCARD")
  extends CreditCard(cardNumber, expirationDate, billingZip, nameOnCard, cardType)