import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "deadbolt-java"
  val appVersion      = "2.2.2-tomondev"

  val appDependencies = Seq(
    javaCore,
    cache,
    "be.objectify" %% "deadbolt-core" % "2.2.1-RC1"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    organization := "be.objectify",
    resolvers += Resolver.url("Objectify Play Repository", url("http://schaloner.github.io/releases/"))(Resolver.ivyStylePatterns),
    resolvers += Resolver.url("Objectify Play Snapshot Repository", url("http://schaloner.github.io/snapshots/"))(Resolver.ivyStylePatterns)
  )
}
