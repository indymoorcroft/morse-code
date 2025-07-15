package org.morseCode

import scala.annotation.tailrec

object InputHandler {

  def translationPicker(): String = {
    val valid = Set("1", "2")

    @tailrec
    def loop(): String = {
      println("Choose mode:\n1. English to Morse\n2. Morse to English")
      
      val input = scala.io.StdIn.readLine().trim

      if (valid.contains(input)) input
      else {
        println("Invalid input. Please enter 1 or 2\n")
        loop()
      }
    }

    loop()
  }

  def readInput(prompt: String): String = {
    println(prompt)
    scala.io.StdIn.readLine()
  }
}
