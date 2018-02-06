import javax.servlet.annotation.WebServlet
import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}

@WebServlet(name = "helloservlet", urlPatterns = Array("/hello/*"))
class HelloServlet extends HttpServlet {

  override def doGet(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    resp.getWriter.println("Hello")
    println("HI")
  }
}
