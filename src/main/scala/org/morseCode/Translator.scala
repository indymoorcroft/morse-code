package org.morseCode

import org.morseCode.MorseCode.*

object Translator {

  def detectMode(input: String): Either[String, String] = {
    val morseChars = Set('.', '-', '/', ' ')

    if(input.nonEmpty && input.forall(morseChars.contains)){
      morseToEnglish(input)
    } else {
      englishToMorse(input)
    }
  }

  def englishToMorse(input: String): Either[String, String] = {
    val convertedToMorse = input.toUpperCase.map {
      case char if morseCode.contains(char) => Right(morseCode(char))
      case c => Left(s"$c")
    }

    combineResults(convertedToMorse.toList).map(_.mkString(" "))
  }

  def morseToEnglish(input: String): Either[String, String] = {
    val words = input.trim.split(" / ").toList

    val convertedToLetters = words.map((word) => {
      val chars = word.split(" ").toList.map((char) => {
        inverseMorseCode.get(char).toRight(s"$char")
      })
      combineResults(chars).map(_.mkString)
    })

    combineResults(convertedToLetters).map(_.mkString(" "))
  }

  private def combineResults[A](results: List[Either[String, A]]): Either[String, List[A]] = {
    val (errors, successes) = results.partitionMap(identity)

    if(errors.nonEmpty){
      Left(errors.mkString((", ")))
    } else {
      Right(successes)
    }
  }
}
