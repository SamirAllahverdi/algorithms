package FreeMarker;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.MultipartConfigElement;

public class Servlet {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8083);
        ServletContextHandler servletContextHandler = new ServletContextHandler();
        TemplateEngine templateEngine = new TemplateEngine("content");

//        servletContextHandler.addServlet(new ServletHolder(new DinamicServlet()), "/d1/*");
//        servletContextHandler.addServlet(new ServletHolder(new DinamicServlet2(templateEngine)), "/d2/*");

        servletContextHandler.addServlet(UploadServlet.class, "/upload/*")
                .getRegistration().setMultipartConfig(new MultipartConfigElement("./from_user"));

        server.setHandler(servletContextHandler);
        server.start();
        server.join();
    }
}
