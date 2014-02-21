import sbt._
import Keys._
import Process._

object ScaladynoBuild extends Build {

  val scalaVer = "2.10.3"

  val defaults = Defaults.defaultSettings ++ Seq(
    scalaVersion := scalaVer,
    scalaBinaryVersion := "2.10",
    scalaSource in Compile <<= baseDirectory(_ / "src"),
    javaSource in Compile <<= baseDirectory(_ / "src"),
    scalaSource in Test <<= baseDirectory(_ / "test"),
    javaSource in Test <<= baseDirectory(_ / "test"),
    resourceDirectory in Compile <<= baseDirectory(_ / "resources"),
    compileOrder := CompileOrder.JavaThenScala,

    unmanagedSourceDirectories in Compile <<= (scalaSource in Compile)(Seq(_)),
    unmanagedSourceDirectories in Test <<= (scalaSource in Test)(Seq(_)),
    //http://stackoverflow.com/questions/10472840/how-to-attach-sources-to-sbt-managed-dependencies-in-scala-ide#answer-11683728
    com.typesafe.sbteclipse.plugin.EclipsePlugin.EclipseKeys.withSource := true,

    libraryDependencies ++= Seq(
      "org.scalacheck" %% "scalacheck" % "1.10.0" % "test",
      "com.novocode" % "junit-interface" % "0.10-M2" % "test"
    ),

    parallelExecution in Test := false,
    testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v"),

    resolvers in ThisBuild ++= Seq(
      Resolver.sonatypeRepo("snapshots"),
      Resolver.sonatypeRepo("releases")),

    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-library" % scalaVer,
      "org.scala-lang" % "scala-reflect" % scalaVer,
      "org.scala-lang" % "scala-compiler" % scalaVer,
      "org.scala-lang" % "scala-partest" % scalaVer,
      "com.googlecode.java-diff-utils" % "diffutils" % "1.2.1"
    ),

    scalacOptions in Compile ++= Seq(
      "-Ytyper-debug",
      "-Ydebug",
      "-Ymacro-debug-lite"
    ),

    addCompilerPlugin("org.scalamacros" %% "paradise" % "2.0.0-SNAPSHOT" cross CrossVersion.full),
    libraryDependencies += "org.scalamacros" %% "quasiquotes" % "2.0.0-SNAPSHOT" cross CrossVersion.full
  )

  lazy val _playground = Project(id = "playground",                base = file(".")) aggregate (macros, scratchpad)
  lazy val macros      = Project(id = "scaladyno-play-macros",     base = file("components/macros"),     settings = defaults)
  lazy val scratchpad  = Project(id = "scaladyno-play-scratchpad", base = file("components/scratchpad"), settings = defaults) dependsOn macros
}
