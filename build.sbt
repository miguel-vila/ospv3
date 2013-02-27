import AssemblyKeys._

assemblySettings

mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
  {
    case x => old(x)
  }
}

test in assembly := {}

jarName in assembly := "ospv3.jar"

organization := "co.s4n.osp"

name := "OSPv3"

version := "0.1"

autoScalaLibrary := false

crossPaths := false

EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource

EclipseKeys.projectFlavor := EclipseProjectFlavor.Java

resolvers ++= Seq(
)

libraryDependencies ++= Seq(
	"com.google.inject" % "guice" % "3.0",
	"org.apache.commons" % "commons-lang3" % "3.1",
	"com.google.guava" % "guava" % "14.0-rc3",
	"junit" % "junit" % "4.10" % "test"
)
