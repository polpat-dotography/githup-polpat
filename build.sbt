import sbt.Keys._

lazy val root = (project in file(".")).
  settings(
    name := "ScalaTest",
    version := "1.0",
    organization := "com.dotography",
    scalaVersion := "2.11.8"
  )

libraryDependencies ++= {
  val liftVersion = "2.6.2"
  Seq(
    "org.scala-lang"    % "scala-reflect"       % scalaVersion.value,
    "org.scala-lang"    % "scala-compiler"      % scalaVersion.value,
    "net.liftweb"       %% "lift-webkit"        % liftVersion        % "compile",
    "net.liftweb"       %% "lift-mapper"        % liftVersion,
    "mysql"             % "mysql-connector-java" % "5.1.36",
    "ch.qos.logback"        % "logback-classic"         % "1.1.6" exclude("log4j", "log4j"),
    "io.igl"                %% "jwt"                    % "1.2.0",
    "com.h2database"    % "h2"                  % "1.4.191"
  )
}
