package service

import javax.inject._

trait Translator {
	def translate(phrase: String) : String
}

class FrenchTranslator extends Translator {
  override def translate(phrase: String) = {
    phrase.toLowerCase().split(" ").map( word => {
      word match {
        case "hello" => "Bonjour"
        case "world" => "monde"
        case x => x
      }
    }).mkString(" ")
  }
}

class SpanishTranslator extends Translator {
  override def translate(phrase: String) = {
    phrase.toLowerCase().split(" ").map( word => {
      word match {
        case "hello" => "Hola"
        case "world" => "mundo"
        case x => x
      }
    }).mkString(" ")
  }
}

trait Greeter {
  def hello() : String
}

@Singleton()
class GreeterImpl extends Greeter {
  def hello() = "HELLO"
}

class HillbillyGreeter extends Greeter {
  def hello() = "HOWDY"
}

object Trans extends App {
  
	val tr = new FrenchTranslator
	println("Translate")
	//println(new GreeterImpl().hello())
	println(tr.translate("hello world mon aime"))
 
}


