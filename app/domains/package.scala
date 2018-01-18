import org.clapper.classutil.ClassInfo

package object domains {

  trait ScalaDoc {
    def classFQN: String
    def scalaDocUrl(scalaVersion: String): String = {
      val fqn = classFQN.replace('.', '/')
      s"https://www.scala-lang.org/api/$scalaVersion/$fqn.html"
    }
  }

  implicit class RichClassInfo(classInfo: ClassInfo) extends ScalaDoc {
    override def classFQN: String = classInfo.name
  }
}
