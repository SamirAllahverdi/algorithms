package workWithGrizzly.server;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class ServerApp {
    public static void main(String[] args) {
        ResourceConfig packages = new ResourceConfig().packages("workWithGrizzly.server.resources");
        GrizzlyHttpServerFactory.createHttpServer(URI.create("http://localhost:8081/shop"),
                packages);

    }
}
