ThisBuild / libraryDependencySchemes += "org.scala-lang.modules" %% "scala-xml" % "always"

libraryDependencies ++= Seq(
  // selenium requires Guava
  "com.google.guava" % "guava"                % "33.2.0-jre",
  "org.scala-js"    %% "scalajs-env-selenium" % "1.1.1"
)

addSbtPlugin("org.scala-js"                % "sbt-scalajs"   % "1.16.0")
addSbtPlugin("org.scalablytyped.converter" % "sbt-converter" % "1.0.0-beta44")
addSbtPlugin("org.scalameta"               % "sbt-scalafmt"  % "2.5.4")
