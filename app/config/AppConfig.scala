package config

import org.springframework.context.annotation._
import config.profiles._
import service._

@Configuration
@ComponentScan(Array("service", "controllers"))
class AppConfig {

  
  @Bean @Dev
  def mockService: HelloService = new MockService()
  
  @Bean @Prod
  def apiService: HelloService = new RealService()
}