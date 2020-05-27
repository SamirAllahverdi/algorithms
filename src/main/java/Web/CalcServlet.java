package Web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class CalcServlet extends HttpServlet {
    private Calculator calc;

    public CalcServlet(Calculator calc) {
        this.calc = calc;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try (OutputStream os = resp.getOutputStream()) {
            Files.copy(Paths.get("content/cupbaCupba.html"), os);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try (OutputStream os = resp.getOutputStream()) {
            Files.copy(Paths.get("content/images/qeni.jpg"),os);
        }
    }
}
