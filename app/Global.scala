import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

import config.AppConfig
import play.api.GlobalSettings

object Global extends GlobalSettings {
  
  private val ctx = new AnnotationConfigApplicationContext
  ctx.getEnvironment().setActiveProfiles("dev")
  ctx.scan("config")
  ctx.refresh
  

  override def getControllerInstance[A](clazz: Class[A]) = {
    ctx.getBean(clazz)
  }
}
