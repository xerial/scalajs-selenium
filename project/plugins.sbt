ThisBuild / libraryDependencySchemes += "org.scala-lang.modules" %% "scala-xml" % "always"

libraryDependencies ++= Seq(
  // selenium requires Guava
  "com.google.guava" % "guava"                % "32.1.3-jre",
  "org.scala-js"    %% "scalajs-env-selenium" % "1.1.1"
)

addSbtPlugin("org.scala-js"                % "sbt-scalajs"   % "1.15.0")
addSbtPlugin("org.scalablytyped.converter" % "sbt-converter" % "1.0.0-beta43")
addSbtPlugin("org.scalameta"               % "sbt-scalafmt"  % "2.5.2")
