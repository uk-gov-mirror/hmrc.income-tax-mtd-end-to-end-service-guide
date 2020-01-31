import play.sbt.PlayImport._
import sbt._

object AppDependencies {

  val compile = Seq(
    ws,
    "uk.gov.hmrc"   %% "bootstrap-play-26" % "1.3.0",
    "uk.gov.hmrc"   %% "play-hmrc-api"     % "3.6.0-play-26",
    "uk.gov.hmrc"   %% "play-hmrc-api"     % "4.1.0-play-26"
  )

  val test = Seq(
    "org.pegdown" % "pegdown" % "1.6.0" % "test",
    "org.scalatest" %% "scalatest" % "3.1.0" % "test",
    "com.vladsch.flexmark"   % "flexmark-all" % "0.35.10"
  )
}
