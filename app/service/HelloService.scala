package service

trait HelloService {
  def hi() : String
}

class MockService extends HelloService {
  def hi() = "HELLO MOCKED"
}

class RealService extends HelloService {
  def hi() = "HELLO REAL"
}