package Web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class StaticServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String imageName = req.getPathInfo();
        String imageLocation = "content/images";
        Path path = Paths.get(imageLocation, imageName);
        try (OutputStream os = resp.getOutputStream()) {
            Files.copy(path, os);
        }


    }
}
