package domains

import java.io.{File => JFile}

import org.clapper.classutil.{ClassFinder, ClassInfo}

case class ScalaClassGetter(files: Seq[JFile]) {
  val finder = ClassFinder(files)
  val getClasses: Stream[ClassInfo] = finder.getClasses()
}

object ScalaClassGetter {

  def apply(file: JFile): ScalaClassGetter = new ScalaClassGetter(Seq(file))

  val scalaStandardLibrary = ScalaClassGetter(new JFile(getClass.getResource("scala-library-2.12.6.jar").getFile))
}