import javax.ws.rs.core.MediaType
import javax.ws.rs.{GET, Path, Produces}

@Path("/rest")
class HelloRestResource {

  @GET
  @Produces(Array(MediaType.TEXT_PLAIN))
  def get(): String = {
    "Rest Hello"
  }
}
