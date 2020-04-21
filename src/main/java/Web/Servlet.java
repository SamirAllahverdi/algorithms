package Web;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Servlet {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8081);
        ServletContextHandler servletContextHandler = new ServletContextHandler();
        Calculator calculator = new Calculator();

        servletContextHandler.addServlet(new ServletHolder(new CalcServlet(calculator)), "/calc/*");
        servletContextHandler.addServlet(new ServletHolder(new StaticServlet("images")), "/img/*");
        servletContextHandler.addServlet(new ServletHolder(new StaticServlet("js")), "/javascript/*");
        servletContextHandler.addServlet(new ServletHolder(new StaticServlet("css")), "/css/*");

//        servletContextHandler.addServlet(new ServletHolder(new TestAddServlet()), "/add");
        server.setHandler(servletContextHandler);
        server.start();
        server.join();
    }
}
