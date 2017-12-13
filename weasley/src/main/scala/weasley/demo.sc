
val myData = Array[String](
  "1\tHarry\tPotter",
  "2\tRon\tWeasley",
  "3\tHermione\tGranger\thermione@hogwarts.ac.uk"
)

case class CustomerName(customerId: Int, firstName: String, lastName: String, email: String)

myData.foreach(customerDataLine => {
  val fields = customerDataLine.split("\t")
  println(CustomerName(fields(0).toInt, fields(1), fields(2), fields(3)))
})

