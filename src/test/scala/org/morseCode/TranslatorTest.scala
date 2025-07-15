package org.morseCode

import org.morseCode.Translator.*
import org.scalatest.funsuite.AnyFunSuite

class TranslatorTest extends AnyFunSuite {

  // englishToMorse
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

  test("Punctuation returns correct morse code") {
    assert(englishToMorse("!").contains("-.-.--"))
  }

  test("Invalid character returns left projection error") {
    assert(englishToMorse("HI%").isLeft)
  }

  // morseToEnglish
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

  // detectMode
  test("Returns Morse code when detecting English input") {
    assert(detectMode("Hello World") == Right(".... . .-.. .-.. --- / .-- --- .-. .-.. -.."))
  }

  test("Returns English letters when detecting Morse Code") {
    assert(detectMode(".... . .-.. .-.. --- / .-- --- .-. .-.. -..") == Right("HELLO WORLD"))
  }

  test("Should fail on invalid symbols") {
    assert(detectMode("..--^").isLeft)
  }

  // loop behaviour

  test("Loop should exit on '#' input") {
    assert(shouldExit("#"))
    assert(shouldExit("   # "))
    assert(!shouldExit("hello"))
  }
}
