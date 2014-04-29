package service

import org.springframework.stereotype.Service

trait Greeter {
  def hello() : String
}

class GreeterImpl extends Greeter {
  def hello() = "HELLO"
}

@Service
class HillbillyGreeter extends Greeter {
  def hello() = "HOWDY"
}