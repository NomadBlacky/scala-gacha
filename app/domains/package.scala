import org.clapper.classutil.ClassInfo

package object domains {

  implicit class RichClassInfo(classInfo: ClassInfo) {
    def scalaDocUrl(version: String): String = {
      val fqn = classInfo.name.replaceAll("\\.", "/")
      s"https://www.scala-lang.org/api/$version/$fqn.html"
    }
  }
}
