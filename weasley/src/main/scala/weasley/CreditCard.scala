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

object CreditCard {
  private var _numberOfCards = 0
  def incrementCardCount: Unit = _numberOfCards += 1
  def cardCount: Int = _numberOfCards

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

  def createCard(cardNumber: String, expirationDate: YearMonth, billingZip: Int, nameOnCard: String): CreditCard = {
    cardTypeFromNumber(cardNumber) match {
      case "AmEx" => new AmericanExpressCard(cardNumber, expirationDate, billingZip, nameOnCard)
      case "Visa" => new VisaCard(cardNumber, expirationDate, billingZip, nameOnCard)
      case "MasterCard" => new MasterCard(cardNumber, expirationDate, billingZip, nameOnCard)
      case _ => null
    }
  }
}