package weasley

import java.time._

class VisaCard(cardNumber: String, expirationDate: YearMonth, billingZip: Int, nameOnCard: String, cardType: String = "VISA")
  extends CreditCard(cardNumber, expirationDate, billingZip, nameOnCard, cardType)