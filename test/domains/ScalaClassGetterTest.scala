package domains

import java.io.File

import org.scalatest.{FunSpec, Matchers}

class ScalaClassGetterTest extends FunSpec with Matchers {
  import ScalaClassGetter._

  describe(".scalaLibraryJar") {
    it("contains `scala-library-x.y.z.jar`") {
      val scalaVersion = util.Properties.versionNumberString
      val jarName = s"""scala-library-$scalaVersion.jar"""

      scalaLibraryJar.toString.contains(jarName) shouldBe true
    }
  }

  describe("#getClasses") {
    it("contains some class informations") {
      val jar = new File(
        getClass.getResource("scala-library-2.12.4.jar").toURI
      )

      val classNames = ScalaClassGetter(Seq(jar)).getClasses.take(3).map(_.name).toList
      classNames shouldBe List(
        "scala.AnyVal",
        "scala.AnyValCompanion",
        "scala.App"
      )
    }
  }
}
