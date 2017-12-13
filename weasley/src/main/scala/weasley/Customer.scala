package weasley

class Customer (
                private var _firstName: String = null,
                private var lastName: String = null,
                private var phoneNumber: String = null,
                var _email: String = null) extends Location {

  require(Customer.validEmail(_email), "Invalid Email!")

  def firstName = {
    println("Getting first Name")
    _firstName
  }
  def firstName_=(fn: String) {
    println("Setting first Name")
    _firstName = fn
  }
    def email = _email
    def email_= (email: String) {
      if (!Customer.validEmail(email)) {
        println("Bad Email: " + email)
      } else {
        _email = email
      }
    }


  override def toString = s"Customer(${_firstName}, $lastName, $phoneNumber, ${_email})" + appendLocationToString
}

object Customer {
  def validEmail(email: String) : Boolean = {
    return email.indexOf('@') > 0
  }
}