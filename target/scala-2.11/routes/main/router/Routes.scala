
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/anuyogamslalom1/microservice/play-java-rest-api-example-2.5.x/conf/routes
// @DATE:Fri Jul 27 14:39:04 UTC 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:1
  HomeController_0: controllers.HomeController,
  // @LINE:3
  posts_Routes_0: posts.Routes,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:1
    HomeController_0: controllers.HomeController,
    // @LINE:3
    posts_Routes_0: posts.Routes
  ) = this(errorHandler, HomeController_0, posts_Routes_0, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, posts_Routes_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """extract""", """controllers.HomeController.db"""),
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    prefixed_posts_Routes_0_2.router.documentation,
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:1
  private[this] lazy val controllers_HomeController_db0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("extract")))
  )
  private[this] lazy val controllers_HomeController_db0_invoker = createInvoker(
    HomeController_0.db,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "db",
      Nil,
      "GET",
      """""",
      this.prefix + """extract"""
    )
  )

  // @LINE:2
  private[this] lazy val controllers_HomeController_index1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index1_invoker = createInvoker(
    HomeController_0.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      """""",
      this.prefix + """"""
    )
  )

  // @LINE:3
  private[this] val prefixed_posts_Routes_0_2 = Include(posts_Routes_0.withPrefix(this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + "v1/posts"))


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:1
    case controllers_HomeController_db0_route(params) =>
      call { 
        controllers_HomeController_db0_invoker.call(HomeController_0.db)
      }
  
    // @LINE:2
    case controllers_HomeController_index1_route(params) =>
      call { 
        controllers_HomeController_index1_invoker.call(HomeController_0.index)
      }
  
    // @LINE:3
    case prefixed_posts_Routes_0_2(handler) => handler
  }
}
