import javax.ws.rs.ApplicationPath

import org.glassfish.jersey.server.ResourceConfig
import resource.HelloRestResource

@ApplicationPath("/application")
class HelloResourceConfig extends ResourceConfig {
  register(classOf[HelloRestResource])
}
