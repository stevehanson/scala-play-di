package service

import org.springframework.stereotype.Service

trait Translator {
	def translate(phrase: String) : String
}

abstract class BaseTranslator extends Translator {
  
  protected val dict: Map[String, String] // override in implementations
  
  override def translate(phrase: String) = {
    phrase.toLowerCase().split(" ").map( word => {
      if (dict.contains(word)) dict(word) else word
    }).mkString(" ")
  }
}

@Service
class FrenchTranslator extends BaseTranslator {
  val dict = Map(
    "hello" -> "Bonjour",
    "world" -> "monde"
  )
}

class SpanishTranslator extends BaseTranslator {
  val dict = Map(
    "hello" -> "Hola",
    "world" -> "mundo"
  )
}