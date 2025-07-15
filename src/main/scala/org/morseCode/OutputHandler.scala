package org.morseCode

object OutputHandler {

  def displayResult(result: Either[String, String]): Unit = {
    result match {
      case Right(output) => println(s"\nResult:\n$output")
      case Left(errors) => println(s"\nError. These characters are not valid:\n${errors.mkString("")}")
    }
  }
}
