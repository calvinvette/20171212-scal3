package weasley

import java.time._

import scala.io.StdIn.readLine

abstract class CreditCard(
                           private var _cardNumber: String,
                           private var _expirationDate: YearMonth,
                           private var _billingZip: Int,
                           private var _nameOnCard: String,
                           private var _cardType: String
                         ) {
  CreditCard.incrementCardCount

  def cardNumber = _cardNumber
  def cardNumber_= (cardNumber: String): Unit = _cardNumber = cardNumber

  def expirationDate = _expirationDate
  def expirationDate_= (expirationDate: YearMonth): Unit = _expirationDate = expirationDate

  def billingZip = _billingZip
  def billingZip_= (billingZip: Int): Unit = _billingZip = billingZip

  def nameOnCard = _nameOnCard
  def nameOnCard_= (nameOnCard: String): Unit = _nameOnCard = nameOnCard

  def cardType = _cardType
  def cardType_= (cardType: String): Unit = _cardType = cardType

  override def toString = s"CreditCard($cardNumber, $expirationDate, $billingZip, $nameOnCard, $cardType)"
}

object CreditCard { // Singleton object; think Java "static"
  private var _numberOfCards = 0
  def incrementCardCount: Unit = _numberOfCards += 1
  def cardCount: Int = _numberOfCards

  def apply(cardNumber: String, expirationDate: YearMonth, billingZip: Int, nameOnCard: String, cardType: String) = {
    createCard(cardNumber, expirationDate, billingZip, nameOnCard) // Ignore cardType; createCard will infer
  }

  def unapply(cc: CreditCard): Option[(String, YearMonth, Int, String, String)] =
    Option((cc.cardNumber, cc.expirationDate, cc.billingZip, cc.nameOnCard, cc.cardType))


  def inputCard(): CreditCard = {
    val cardNumber = readLine("Card Number:\t")
    val expirationDateString = readLine("Expiration Date (MM/DDDD):\t")
    val parts = expirationDateString.split('/')
    val (expMonth, expYear) = (parts(0), parts(1))
    val expirationDate = YearMonth.of(expYear.toInt, expMonth.toInt)
    val billingZip = readLine("Billing Zipcode:\t").toInt
    val nameOnCard = readLine("Name on Card:\t")
    createCard(cardNumber, expirationDate, billingZip, nameOnCard)
  }

  def isExpired(expirationDate: YearMonth): Boolean = YearMonth.now.isAfter(expirationDate)

  def isExpired(card: CreditCard): Boolean = YearMonth.now.isAfter(card.expirationDate)

  def cardTypeFromNumber(cardNumber: String): String = (cardNumber.charAt(0)) match {
    case '3' => "AmEx"
    case '4' => "Visa"
    case '5' => "MasterCard"
    case '6' => "Discover"
    case _ => "UNK"
  }

  def createCard(cardNumber: String,
                 expirationDate: YearMonth,
                 billingZip: Int,
                 nameOnCard: String): CreditCard = {
    cardTypeFromNumber(cardNumber) match {
      case "AmEx" => new AmericanExpressCard(cardNumber, expirationDate, billingZip, nameOnCard)
      case "Visa" => new VisaCard(cardNumber, expirationDate, billingZip, nameOnCard)
      case "MasterCard" => new MasterCard(cardNumber, expirationDate, billingZip, nameOnCard)
      case _ => null
    }
  }

  def checkCard(cc: CreditCard): String = {
    cc match {
      case crd: MasterCard if CreditCard.isExpired(crd) => "MC expired"
      case CreditCard("5111-1111-1111-1111", _, _, _, _) => "MC Testing Card"
      case _: MasterCard => "Regular MC card, not expired"
      case _ => "Not an MC Card"
    }
  }

}