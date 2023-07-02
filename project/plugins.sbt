ThisBuild / libraryDependencySchemes += "org.scala-lang.modules" %% "scala-xml" % "always"

libraryDependencies ++= Seq(
  // selenium requires Guava
  "com.google.guava" % "guava" % "31.1-jre",
  "org.scala-js" %% "scalajs-env-selenium" % "1.1.1"
)

addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.13.2")
addSbtPlugin("org.scalablytyped.converter" % "sbt-converter" % "1.0.0-beta42")
