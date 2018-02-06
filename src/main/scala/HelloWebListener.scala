import javax.servlet.annotation.WebListener
import javax.servlet.{ServletContextEvent, ServletContextListener}

import org.glassfish.jersey.servlet.ServletContainer

import collection.JavaConverters._

@WebListener
class HelloWebListener extends ServletContextListener {

  override def contextInitialized(event: ServletContextEvent) {
    addRestResources(event)
  }

  private def addRestResources[T](event: ServletContextEvent): Unit = {
    val resourceConfig = new HelloResourceConfig
    val servlet = new ServletContainer(resourceConfig)
    resourceConfig.getClasses.asScala.foreach(clazz => {
      event.getServletContext.addServlet(clazz.getName, servlet).addMapping(classToContextPath(clazz))
    })
  }

  private def classToContextPath[T](clazz: Class[T]): String = {
    val className = clazz.getName.toLowerCase()
    val contextName = className.replace("servlet","").replace("resource", "")
    val contextPath = s"/$contextName/*"
    println(contextPath)
    contextPath
  }

  override def contextDestroyed(servletContextEvent: ServletContextEvent): Unit = {

  }
}