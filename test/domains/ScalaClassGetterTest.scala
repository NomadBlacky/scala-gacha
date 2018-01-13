package domains

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
}
