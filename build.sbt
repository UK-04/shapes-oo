name := "shapes-oo-scala"

version := "0.5"

libraryDependencies ++= Seq(
  "org.creativescala"          %% "doodle"            % "0.34.0",
  "com.typesafe.scala-logging" %% "scala-logging"     % "3.9.5",
  "ch.qos.logback"             %  "logback-classic"   % "1.5.6",
  "com.github.sbt.junit"       %  "jupiter-interface" % JupiterKeys.jupiterVersion.value % Test
)
