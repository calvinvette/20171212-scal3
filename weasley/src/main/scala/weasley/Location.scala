package weasley

trait Location {
  var _latitude: Double = 0
  var _longitude: Double = 0
  var _postalCode: String = null
  var _city: String = null
  var _state: String = null
  var _country: String = null

  def latitude = _latitude
  def latitude_= (latitude: Double) : Unit = _latitude = latitude

  def longitude = _longitude
  def longitude_= (longitude: Double) : Unit = _longitude = longitude

  def postalCode = _postalCode
  def postalCode_= (postalCode: String) : Unit = _postalCode = postalCode

  def city = _city
  def city_= (city: String) : Unit = _city = city

  def state = _state
  def state_= (state: String) : Unit = _state = state

  def country = _country
  def country_= (country: String) : Unit = _country = country

  def appendLocationToString: String = s" Location: $city, $state, $postalCode, $country @($latitude,$longitude)"

}