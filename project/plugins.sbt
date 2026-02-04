ThisBuild / libraryDependencySchemes += "org.scala-lang.modules" %% "scala-xml" % "always"

libraryDependencies ++= Seq(
  // selenium requires Guava
  "com.google.guava" % "guava"                % "33.2.1-jre",
  "org.scala-js"    %% "scalajs-env-selenium" % "1.1.1"
)

addSbtPlugin("org.scala-js"                % "sbt-scalajs"   % "1.20.2")
addSbtPlugin("org.scalablytyped.converter" % "sbt-converter" % "1.0.0-beta45")
addSbtPlugin("org.scalameta"               % "sbt-scalafmt"  % "2.5.6")
