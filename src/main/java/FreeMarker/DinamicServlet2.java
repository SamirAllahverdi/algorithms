package FreeMarker;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DinamicServlet2 extends HttpServlet {
    private final TemplateEngine templateEngine;

    public DinamicServlet2(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        List<Student> students = Arrays.asList(
                new Student("Jim", 20, "BE4"),
                new Student("Jack", 21, "BE3"),
                new Student("Jeremy", 25, "BE1")
        );
        HashMap<String,Object> data = new HashMap<>();
        data.put("students",students);
        templateEngine.render("dinamic2.ftl", data, resp);
    }
}
