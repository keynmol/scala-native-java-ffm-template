import sbt_jextract.*
import bindgen.interface.*, bindgen.plugin.*
import scalanative.build.BuildTarget

val Versions = new {
  val Scala3 = "3.6.3"
}

lazy val root = project.in(file(".")).aggregate(jvmSide, scalaNativeSide)

val jvmSide = project
  .in(file("mod/jvm"))
  .enablePlugins(JextractPlugin)
  .settings(
    jextractBindings += JextractBinding(
      (ThisBuild / baseDirectory).value / "mod/interface.h",
      "myscalalib_bindings"
    ),
    jextractMode := JextractMode.Manual(
      sourceDirectory.value / "main/java/generated"
    ),
    Compile / resourceGenerators += Def.task {
      val scalaLib = (scalaNativeSide / Compile / nativeLink).value
      val dest =
        (Compile / resourceManaged).value / (scalaLib.asPath
          .getFileName()
          .toString)
      IO.copyFile(scalaLib, dest)

      Seq(dest)
    },
    run / fork := true,
    javaOptions += "--enable-native-access=ALL-UNNAMED"
  )

lazy val scalaNativeSide = project
  .in(file("mod/scala-native"))
  .enablePlugins(ScalaNativePlugin, BindgenPlugin)
  .settings(
    publish / skip := true,
    publishLocal / skip := true,
    scalaVersion := Versions.Scala3,
    bindgenBindings :=
      Seq(
        Binding(
          (ThisBuild / baseDirectory).value / "mod/interface.h",
          "myscalalib"
        ).withExport(true).withNoLocation(true)
      ),
    bindgenMode := BindgenMode.Manual(
      scalaDir = (Compile / sourceDirectory).value / "scala" / "generated",
      cDir = (Compile / resourceDirectory).value / "scala-native" / "generated"
    ),
    bindgenBindings := {
      bindgenBindings.value.map(_.withNoLocation(true))
    },
    nativeConfig ~= { _.withBuildTarget(BuildTarget.libraryDynamic) }
  )
