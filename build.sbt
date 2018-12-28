import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.7",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "kafka",
    libraryDependencies ++=
      "org.apache.kafka" % "kafka-streams" % "2.1.0" ::
        "org.apache.kafka" %% "kafka" % "2.1.0" ::
        "org.apache.kafka" % "kafka-clients" % "2.1.0" ::
        "org.scalatest" %% "scalatest" % "3.0.5" % "test"::
        "io.argonaut" %% "argonaut" % "6.2.2"::
        "io.argonaut" %% "argonaut-cats" % "6.2.2"::
      Nil
  )
