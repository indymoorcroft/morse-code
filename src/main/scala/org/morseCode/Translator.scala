package org.morseCode

object Translator {

  def englishToMorse(input: String): Either[String, String] = {
    val convertedToMorse = input.toUpperCase.map {
      case char if MorseCode.morseCode.contains(char) => Right(MorseCode.morseCode(char))
      case c => Left(s"Invalid character: $c")
    }

    combineResults(convertedToMorse.toList).map(_.mkString(" "))
  }

  private def combineResults(results: List[Either[String, String]]): Either[String, List[String]] = {
    results.foldRight(Right(Nil): Either[String, List[String]]) { (current, accumulated) =>
      for {
        valid <- current
        rest <- accumulated
      } yield valid :: rest // prepends
    }
  }
}
