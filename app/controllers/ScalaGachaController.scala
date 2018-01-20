package controllers

import javax.inject.{Inject, Singleton}

import domains.ScalaClassGetter
import org.clapper.classutil.ClassInfo
import play.api.Play
import play.api.libs.json.Json
import play.api.mvc._

import scala.util.Random

@Singleton
class ScalaGachaController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index = Action {
    Ok("Hey")
  }

  def gacha = Action {
    val f = Play.routesCompilerMaybeApplication.get.environment.getFile("conf/scala-library-2.12.4.jar")
    val classes: List[ClassInfo] = {
      val classGetter = ScalaClassGetter(Seq(
        f
      ))
      Random.shuffle(classGetter.getClasses).toList
    }

    val clazz = classes(Random.nextInt(classes.size))
    Ok(Json.toJson(clazz))
  }
}
