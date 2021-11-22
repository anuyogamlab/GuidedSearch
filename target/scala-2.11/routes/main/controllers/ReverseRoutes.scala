
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/anuyogamslalom1/microservice/play-java-rest-api-example-2.5.x/conf/routes
// @DATE:Fri Jul 27 14:39:04 UTC 2018

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:1
package controllers {

  // @LINE:1
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:2
    def index(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix)
    }
  
    // @LINE:1
    def db(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "extract")
    }
  
  }


}
