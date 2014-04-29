package controllers


import play.api.mvc.Action
import play.api.mvc.Controller
import service.Greeter
import service.Translator
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowire
import org.springframework.beans.factory.annotation.Autowired
import service.HelloService

@Service
class Translate @Autowired() (translator: Translator, greeter: Greeter, helloService: HelloService) extends Controller {

  def index() = Action {
    Ok(views.html.greet( translator.translate("Hello world"), greeter.hello(), helloService.hi() ))
  }
  
}