import sbt._, Keys._

object Publish extends AutoPlugin {

  override def projectSettings = Seq(
    credentials += Credentials(Path.userHome / ".ivy2" / ".credentials"),
    publishTo := {
      val nexus = "http://repo02.tecniplastgroup.com:8081/"

      if (isSnapshot.value) {
        Some("snapshots" at nexus + "repository/maven-snapshots/")
      } else
        Some("releases"  at nexus + "repository/maven-releases/")
    }
  )

}
