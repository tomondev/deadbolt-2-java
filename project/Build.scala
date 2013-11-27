import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "deadbolt-java"
<<<<<<< HEAD
  val appVersion      = "2.1.5-tomondev"

  val appDependencies = Seq(
    javaCore,
    "be.objectify" %% "deadbolt-core" % "2.1.5-tomondev"
=======
  val appVersion      = "2.2-RC2"

  val appDependencies = Seq(
    javaCore,
      cache,
    "be.objectify" %% "deadbolt-core" % "2.2-RC2"
>>>>>>> upstream/master
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    organization := "be.objectify",
    resolvers += Resolver.url("Objectify Play Repository", url("http://schaloner.github.com/releases/"))(Resolver.ivyStylePatterns),
    resolvers += Resolver.url("Objectify Play Snapshot Repository", url("http://schaloner.github.com/snapshots/"))(Resolver.ivyStylePatterns)
  )
}
