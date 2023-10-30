import org.scalajs.linker.interface.ModuleSplitStyle
import org.openqa.selenium.chrome.ChromeOptions
import org.scalajs.jsenv.selenium.SeleniumJSEnv

Global / onChangedBuildSource := ReloadOnSourceChanges

val publicDev  = taskKey[String]("output directory for `npm run dev`")
val publicProd = taskKey[String]("output directory for `npm run build`")

lazy val seleniumTest = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin)
  .enablePlugins(ScalablyTypedConverterExternalNpmPlugin)
  .settings(
    scalaVersion := "3.3.1",
    scalacOptions ++= Seq("-encoding", "utf-8", "-deprecation", "-feature"),
    libraryDependencies += "org.wvlet.airframe" %%% "airspec" % "23.11.0" % Test,
    testFrameworks += new TestFramework("wvlet.airspec.Framework"),
    scalaJSUseMainModuleInitializer := true,
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
        .withModuleSplitStyle(ModuleSplitStyle.SmallestModules)
    },
    Test / jsEnv := {
      val options = new ChromeOptions()
      // Need to disable CORS check for local testing
      options.addArguments(
        "--disable-web-security"
        //  "--no-sandbox"
      )
      options.setHeadless(true)
      new SeleniumJSEnv(options, SeleniumJSEnv.Config())
    },
    externalNpm := {
      scala.sys.process.Process(List("npm", "install", "--silent", "--no-audit", "--no-fund"), baseDirectory.value).!
      baseDirectory.value
    },
    Test / parallelExecution := false,
    libraryDependencies ++= Seq(
      "org.seleniumhq.selenium" % "selenium-java"    % "4.14.1" % Test,
      "org.wvlet.airframe"    %%% "airframe-rx-html" % "23.11.0"
    ),
    publicDev  := linkerOutputDirectory((Compile / fastLinkJS).value).getAbsolutePath(),
    publicProd := linkerOutputDirectory((Compile / fullLinkJS).value).getAbsolutePath()
  )

def linkerOutputDirectory(v: Attributed[org.scalajs.linker.interface.Report]): File = {
  v.get(scalaJSLinkerOutputDirectory.key).getOrElse {
    throw new MessageOnlyException(
      "Linking report was not attributed with output directory. " +
        "Please report this as a Scala.js bug."
    )
  }
}
