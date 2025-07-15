package org.morseCode

import scala.annotation.tailrec

object InputHandler {

  def translationPicker(): String = {
    getValidInput(Set("1", "2"), "Choose mode:\n1. English to Morse\n2. Morse to English")
  }

  def readInput(prompt: String): String = {
    println(prompt)
    scala.io.StdIn.readLine()
  }

  @tailrec
  def getValidInput(validInputs: Set[String], prompt: String): String = {
    println(prompt)

    val input = scala.io.StdIn.readLine().trim.toLowerCase

    if (validInputs.contains(input)) input
    else {
      println(s"Invalid input. Please enter ${validInputs.toList.sorted.mkString(" or ")}\n")
      getValidInput(validInputs, prompt)
    }
  }
}
