package controllers

import javax.inject._
import play.api.mvc.Action
import play.api.mvc.Controller
import service.Greeter
import service.Translator

@Singleton
class Translate @Inject() (translator: Translator, greeter: Greeter) extends Controller {

  def greet() = Action {
    Ok(views.html.greet( translator.translate("Hello world"), greeter.hello() ))
  }
  
}