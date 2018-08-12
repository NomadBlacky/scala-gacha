import com.typesafe.sbt.packager.docker.{Cmd, ExecCmd}

name := """scala-gacha"""
organization := "org.nomadblacky"

version := "1.0-SNAPSHOT"

enablePlugins(PlayScala)
enablePlugins(JavaServerAppPackaging)

dockerBaseImage := "openjdk:8u171-jdk-alpine3.8"
dockerCommands ++= Seq(
  Cmd("USER", "root"),
  ExecCmd("RUN", "apk", "add", "--no-cache", "bash")
)
dockerExposedPorts := Seq(9000, 9000)

scalaVersion := "2.12.6"

libraryDependencies += guice
libraryDependencies ++= Seq(
  "org.clapper" %% "classutil" % "1.2.0",
  "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
)

resourceDirectories in Compile += file("resources")

mappings in Universal ++= Seq(
  file("Procfile") -> "Procfile",
  file("lib/dd-java-agent-0.11.0.jar") -> "dd-java-agent.jar"
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "org.nomadblacky.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "org.nomadblacky.binders._"
