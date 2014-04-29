import com.google.inject.Guice
import play.api.GlobalSettings
import play.api.Play
import play.api.Play.current
import com.tzavellas.sse.guice.ScalaModule
import service.Translator
import service.FrenchTranslator
import service.SpanishTranslator
import service.Greeter
import service.HillbillyGreeter

object Global extends GlobalSettings {
  
  
  val injector = Guice.createInjector(new ScalaModule {
    protected def configure() {
      bind[Translator].to[FrenchTranslator]
      bind[Greeter].to[HillbillyGreeter]
    }
  })
  
  
//  private lazy val injector = {
//    Play.isProd match {
//      case true => Guice.createInjector(new ProdModule)
//      case false => Guice.createInjector(new DevModule)
//    }
//  }

  override def getControllerInstance[A](clazz: Class[A]) = {
    injector.getInstance(clazz)
  }
}

class ProdModule extends ScalaModule {
  def configure() {
    bind[Translator].to[FrenchTranslator]
  }
}
 
class DevModule extends ScalaModule {
  def configure() {
    bind[Translator].to[SpanishTranslator]
  }
}