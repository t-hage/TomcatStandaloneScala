import org.glassfish.jersey.server.ResourceConfig

class HelloResourceConfig extends ResourceConfig {
  register(classOf[HelloRestResource])
}
