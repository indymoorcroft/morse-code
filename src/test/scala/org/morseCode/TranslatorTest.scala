package org.morseCode

import org.scalatest.funsuite.AnyFunSuite

class TranslatorTest extends AnyFunSuite {

  // 1. englishToMorse
  test("English letter returns correct morse code") {
    assert(Translator.englishToMorse("H").contains("...."))
  }

  test("English word returns correct morse code") {
    assert(Translator.englishToMorse("HELLO").contains(".... . .-.. .-.. ---"))
  }

  test("Two english words with space returns correct morse code") {
    assert(Translator.englishToMorse("HELLO WORLD").contains(".... . .-.. .-.. --- / .-- --- .-. .-.. -.."))
  }

  test("Lowercase english letter returns correct morse code") {
    assert(Translator.englishToMorse("h").contains("...."))
  }

  test("Invalid character returns left projection error") {
    assert(Translator.englishToMorse("HI!").isLeft)
  }
}
