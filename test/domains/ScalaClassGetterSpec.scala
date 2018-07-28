package domains

import org.scalatest.{FunSpec, Matchers}

class ScalaClassGetterSpec extends FunSpec with Matchers {

  describe("#getClasses") {
    it("contains some class informations") {
      val classNames = ScalaClassGetter.scalaStandardLibrary.getClasses.take(3).map(_.name).toList
      classNames shouldBe List(
        "scala.AnyVal",
        "scala.AnyValCompanion",
        "scala.App"
      )
    }
  }
}
