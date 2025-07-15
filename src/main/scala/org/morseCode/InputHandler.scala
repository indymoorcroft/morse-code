package org.morseCode

import scala.annotation.tailrec
import scala.util.{Failure, Success, Try}

object InputHandler {

  def translationPicker(): String = {
    println("Choose mode:\n1. English to Morse\n2. Morse to English")
    def attempt(): Try[String] = Try {
      val input = scala.io.StdIn.readLine().trim

      if(input != "1" && input != "2") {
        throw new InvalidInputException("Please enter 1 or 2")
      }

      input match {
        case "1" => "English to Morse"
        case "2" => "Morse to English"
      }
    }

    @tailrec
    def loop(): String = {
      attempt() match {
        case Success(c) => c
        case Failure(e) =>
          println(s"Invalid: ${e.getMessage}")
          loop()
      }
    }
    loop()
  }

  def readInput(prompt: String): String = {
    println(prompt)
    scala.io.StdIn.readLine()
  }

  private class InvalidInputException(msg: String) extends Exception(msg)
}
