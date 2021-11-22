
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/anuyogamslalom1/microservice/play-java-rest-api-example-2.5.x/conf/posts.routes
// @DATE:Fri Jul 27 12:28:39 UTC 2018

package v1.post;

import posts.RoutesPrefix;

public class routes {
  
  public static final v1.post.ReversePostController PostController = new v1.post.ReversePostController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final v1.post.javascript.ReversePostController PostController = new v1.post.javascript.ReversePostController(RoutesPrefix.byNamePrefix());
  }

}
