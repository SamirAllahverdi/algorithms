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
//        String content = new BufferedReader(new FileReader(new File("content/cupbaCupba.html"))).
//                lines().collect(Collectors.joining("\n"));
//
//        try (PrintWriter writer = resp.getWriter()) {
//            writer.write(content);
//        }
        try (OutputStream os = resp.getOutputStream()) {
            Files.copy(Paths.get("content/cupbaCupba.html"), os);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String op = req.getParameter("op");
        if(op.equals("add")){
            resp.sendRedirect("http://www.google.com");
        }
        String x = req.getParameter("x");
        String y = req.getParameter("y");
        try (PrintWriter writer = resp.getWriter()) {
            writer.write(calc.doOperation(x,y,op));
        }
    }
}
