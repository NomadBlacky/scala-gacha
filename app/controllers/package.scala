import domains.RichClassInfo
import org.clapper.classutil.ClassInfo
import play.api.libs.json._

import scala.util.Properties

package object controllers {

  implicit val classInfoWrites: Writes[ClassInfo] = (info: ClassInfo) => {
    Json.obj(
      "classFQN" -> info.name,
      "superClass" -> info.superClassName,
      "scaladoc" -> info.scalaDocUrl(Properties.versionNumberString)
    )
  }
}
