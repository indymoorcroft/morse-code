package org.morseCode

import org.morseCode.InputHandler.*
import org.morseCode.Translator.*

object Main extends App {
  val picked = translationPicker()

  val input = readInput(s"You have chosen $picked. Please type in your language to get your translation")

  if (picked == "englishToMorse") println(englishToMorse(input)) else println(morseToEnglish(input))
}
