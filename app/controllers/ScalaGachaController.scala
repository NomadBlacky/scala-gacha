package controllers

import domains.ScalaClassGetter
import javax.inject.{Inject, Singleton}
import org.clapper.classutil.ClassInfo
import play.api.libs.json.Json
import play.api.mvc._

import scala.util.Random

@Singleton
class ScalaGachaController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index = Action {
    Ok("Hey")
  }

  def gacha = Action {
    val classes: List[ClassInfo] = Random.shuffle(ScalaClassGetter.scalaStandardLibrary.getClasses).toList
    val clazz = classes(Random.nextInt(classes.size))
    Ok(Json.toJson(clazz))
  }
}
