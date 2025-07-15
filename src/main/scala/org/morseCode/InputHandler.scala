package org.morseCode

object InputHandler {

  def readInput(prompt: String): String = {
    println(prompt)
    scala.io.StdIn.readLine()
  }

}
