
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/anuyogamslalom1/microservice/play-java-rest-api-example-2.5.x/conf/routes
// @DATE:Fri Jul 27 14:39:04 UTC 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
