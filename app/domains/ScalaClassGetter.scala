package domains

import java.net.{URL, URLClassLoader}

case class ScalaClassGetter(url: URL) {

}

object ScalaClassGetter {

  lazy val runtimeClassPaths: Seq[URL] = {
    import collection.mutable.ListBuffer

    def urls(cl: ClassLoader): ListBuffer[URL] = cl match {
      case null => ListBuffer.empty
      case u: URLClassLoader => u.getURLs ++: urls(cl.getParent)
      case _ => urls(cl.getParent)
    }

    urls(ClassLoader.getSystemClassLoader).toList
  }

  val scalaLibraryJarRegex =
    s"""file:.*scala-library-${util.Properties.versionNumberString}.jar$$"""

  lazy val scalaLibraryJar: URL =
    runtimeClassPaths
      .find(_.toString.matches(scalaLibraryJarRegex))
      .getOrElse(throw scalaJarNotFound)

  private val scalaJarNotFound =
    new IllegalStateException(
      s"Not found Scala library ${util.Properties.versionNumberString} in runtime class paths."
    )
}