package org.morseCode

import org.morseCode.Translator.*
import org.scalatest.funsuite.AnyFunSuite

class TranslatorTest extends AnyFunSuite {

  // 1. englishToMorse
  test("English letter returns correct morse code") {
    assert(englishToMorse("H").contains("...."))
  }

  test("English word returns correct morse code") {
    assert(englishToMorse("HELLO").contains(".... . .-.. .-.. ---"))
  }

  test("Two english words with space returns correct morse code") {
    assert(englishToMorse("HELLO WORLD").contains(".... . .-.. .-.. --- / .-- --- .-. .-.. -.."))
  }

  test("Lowercase english letter returns correct morse code") {
    assert(englishToMorse("h").contains("...."))
  }

  test("Invalid character returns left projection error") {
    assert(englishToMorse("HI!").isLeft)
  }

  // 2. morseToEnglish
  test("Morse code letter returns correct english letter") {
    assert(morseToEnglish("....").contains("H"))
  }

  test("Morse code word returns correct english word") {
    assert(morseToEnglish(".... . .-.. .-.. ---").contains("HELLO"))
  }

  test("Two morse code words returns correct english words") {
    assert(morseToEnglish(".... . .-.. .-.. --- / .-- --- .-. .-.. -..").contains("HELLO WORLD"))
  }

  test("Invalid morse code returns left projection error") {
    assert(morseToEnglish("....----..").isLeft)
  }
}
