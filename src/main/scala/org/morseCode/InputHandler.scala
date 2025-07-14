package org.morseCode

object InputHandler {

  def translationPicker(): String = {
    println("Choose mode:\n1. English to Morse\n2. Morse to English")
    val input = scala.io.StdIn.readLine().trim
    input match {
      case "1" => "English to Morse"
      case "2" => "Morse to English"
      case _ => "Invalid option. Try again"
    }
  }

  def readInput(prompt: String): String = {
    println(prompt)
    scala.io.StdIn.readLine()
  }

}
