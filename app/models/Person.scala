package models
import play.api.db.slick.Config.driver.simple._


/*
 * Person (1...*) Address
 * 
 */

case class Person(id: Option[Int], name: String, age: Int)
case class Address(id: Option[Int], personId: Int, address1: String, state: String)


class PersonTable(tag: Tag) extends Table[Person](tag, "PERSON") {
  def id = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)
  def name = column[String]("name")
  def age = column[Int]("age")
  
  //def addresses = TableQuery[AddressTable].filter(_.person_id === this.id).list

  def * = (id, name, age) <> (Person.tupled, Person.unapply _)
}

class AddressTable(tag: Tag) extends Table[Address](tag, "ADDRESS") {
  def id = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)
  def personID = column[Int]("PERSON_ID")
  def address1 = column[String]("address1")
  def state = column[String]("state")
  
  def person = foreignKey("PERSON_FK", personID, TableQuery[PersonTable])(_.id.getOrElse(0))
  //def person = TableQuery[PersonTable].filter(_.id.getOrElse(0) === this.person_id).list

  def * = (id, personID, address1, state) <> (Address.tupled, Address.unapply _)
}
