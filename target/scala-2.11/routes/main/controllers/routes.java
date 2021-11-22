
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/anuyogamslalom1/microservice/play-java-rest-api-example-2.5.x/conf/routes
// @DATE:Fri Jul 27 14:39:04 UTC 2018

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
  }

}
