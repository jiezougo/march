import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "bizwise"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
    javaJpa,
    "org.hibernate" % "hibernate-entitymanager" % "3.6.9.Final",
    "mysql" % "mysql-connector-java" % "5.1.19"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )
  
}
