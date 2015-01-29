lazy val root = (project in file(".")).
  settings(
    name := "scala-lambda",
    version := "0.0.1",
    scalaVersion := "2.11.5",
    libraryDependencies ++= Seq(
      "jline" % "jline" % "2.12",
      "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.3",
      "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test"
    )
  )
