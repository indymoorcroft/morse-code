package org.morseCode

import org.morseCode.InputHandler.*
import org.morseCode.OutputHandler.displayResult
import org.morseCode.Translator.*

import scala.annotation.tailrec

object Main extends App {

  @tailrec
  private def runTranslator(): Unit = {
    val mode = translationPicker()

    val input = readInput(if (mode == "1") "\nYou have chosen English to Morse. Enter English text:" else "\nYou have chosen Morse to English. Enter Morse code:")

    val result = mode match {
      case "1" => englishToMorse(input)
      case "2" => morseToEnglish(input)
    }

    displayResult(result)

    val continue = getValidInput(Set("y", "n"), "\nWould you like to do another translation? (y/n): ")

    if(continue == "y") runTranslator()
    else println("\nGoodbye!")
  }

  runTranslator()
}
