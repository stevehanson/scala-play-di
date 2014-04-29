package models

import java.sql.Date

import play.api._
import play.api.Play.current
import play.api.data.Forms._
import play.api.db.slick._
import play.api.db.slick.Config.driver.simple._
import play.api.db.slick.Config.driver.simple._
import play.api.libs.json.Json._
import play.api.mvc.BodyParsers._

//case class Tournament(id: Option[Int], name: String, start: Date, teams: List[Team])
//case class Team(id: Option[Int], name: String)
//
//
///* Table mapping
// */
//class TournamentsTable(tag: Tag) extends Table[Tournament](tag, "TOURNAMENT") {
//  def id = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)
//  def name = column[String]("name", O.PrimaryKey)
//  def start = column[Date]("start", O.NotNull)
//  
//  def teams = TableQuery[TeamTable].filter(_.tournament_id === this.id).list
//
//  def * = (id, name, start, teams) <> (Tournament.tupled, Tournament.unapply _)
//}
//
//class TeamTable(tag: Tag) extends Table[Team](tag, "TEAM") {
//  def id = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)
//  def name = column[String]("name")
//
//  def * = (id, name) <> (Team.tupled, Team.unapply _)
//}
