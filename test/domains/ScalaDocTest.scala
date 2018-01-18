package domains

import org.scalatest.{FunSpec, Matchers}

class ScalaDocTest extends FunSpec with Matchers {

  describe("#scalaDocUrl") {
    it("should returns the URL of Scala standard library") {
      val scaladoc = new ScalaDoc {
        def classFQN: String = "scala.hoge.foo.Clazz"
      }
      val expect = "https://www.scala-lang.org/api/x.y.z/scala/hoge/foo/Clazz.html"
      scaladoc.scalaDocUrl("x.y.z") shouldBe expect
    }
  }
}
