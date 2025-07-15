package org.morseCode

import org.morseCode.InputHandler.*
import org.morseCode.Translator.*

object Main extends App {
  val num: String = translationPicker()

  val picked: String = num match {
    case "1" => "English to Morse"
    case "2" => "Morse to English"
  }

  val input = readInput(s"You have chosen ${picked}. Please type in your language to get your translation")

  if (num == "1") println(englishToMorse(input)) else println(morseToEnglish(input))
}
