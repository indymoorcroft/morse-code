package org.morseCode

import org.morseCode.InputHandler.readInput
import org.morseCode.OutputHandler.displayResult
import org.morseCode.Translator.detectMode

import scala.annotation.tailrec

object Main extends App {

  println("Hello! Welcome to the Morse code Translator. Here's how to use it: \n- Type English letters to receive a Morse code translation\n- Type Morse code to receive an English translation\n- Type '#' to quit")

  @tailrec
  private def runTranslator(): Unit = {

    val input = readInput("\nEnter text: ")

    val result = detectMode(input)

    if(input.equals("#")){
      println("Goodbye")
    } else {
      val result = detectMode(input)
      displayResult(result)
      runTranslator()
    }
  }

  runTranslator()
}
