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

    if(!shouldExit(input)){
      val result = detectMode(input)
      displayResult(result)
      runTranslator()
    } else {
      println("\nGoodbye. Thank you for using the Morse code Translator")
    }
  }

  runTranslator()
}

def shouldExit(input: String): Boolean = input.trim.equals("#")
