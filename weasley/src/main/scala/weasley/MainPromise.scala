package weasley

import java.io.FileNotFoundException

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success}

object MainPromise extends App {
  def readFile(fileName: String): List[String] = {
    io.Source.fromFile(fileName).getLines().toList
  }

  val data = for {
    keys <- Future { readFile("keys.txt") }
    values <- Future { readFile("values.txt") }
  } yield keys.zip(values).toMap

  data.recover {
    case e: java.io.FileNotFoundException => {
      println("Recover found FNFE: " + e.getMessage)
      Map[String, String](e.getClass.toString -> e.getMessage)
    }
  }

  data onComplete {
    case Success(map) => println(map)
    case Failure(t) => println("Error: " + t.getMessage)
  }

  println("Before Await")
  Await.result(data, Duration.Inf)
  println("After Await")

}
