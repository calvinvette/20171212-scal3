package weasley

import scala.io.StdIn.readLine

object HelloScala {

  def main(args: Array[String]): Unit = {
    val firstName = readLine("First Name>\t")
    val lastName = readLine("Last Name>\t")
    val phoneNumber = readLine("Phone Number>\t")
    val email = readLine("Email>\t\t")
    val cust = new Customer(firstName, lastName, phoneNumber, email)
    println("Hello, " + cust.firstName + "!")
    cust.email = "bad email"
    println(cust)

  }

}