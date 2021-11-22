
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/anuyogamslalom1/microservice/play-java-rest-api-example-2.5.x/conf/posts.routes
// @DATE:Fri Jul 27 12:28:39 UTC 2018


package posts {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
