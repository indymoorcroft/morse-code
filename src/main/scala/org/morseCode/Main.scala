package org.morseCode

import org.morseCode.InputHandler.*
import org.morseCode.OutputHandler.displayResult
import org.morseCode.Translator.*

object Main extends App {
  private val mode = translationPicker()

  val input = readInput(if(mode == "1") "\nYou have chosen English to Morse. Enter English text:" else "\nYou have chosen Morse to English. Enter Morse code:")

  val result = mode match {
    case "1" => englishToMorse(input)
    case "2" => morseToEnglish(input)
  }

  displayResult(result)
}
