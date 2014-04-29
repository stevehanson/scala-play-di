name := "api"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "com.typesafe.slick" %% "slick" % "2.0.1",
  "com.typesafe.play" %% "play-slick" % "0.6.0.1",
  "org.springframework" % "spring-context" % "4.0.3.RELEASE",
  "javax.inject" % "javax.inject" % "1"
)     

play.Project.playScalaSettings
