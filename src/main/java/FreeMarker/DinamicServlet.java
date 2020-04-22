package FreeMarker;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class DinamicServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Configuration (freeMarketTemplate version)
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
        configuration.setDirectoryForTemplateLoading(new File("./content"));
        configuration.setDefaultEncoding(String.valueOf(StandardCharsets.UTF_8));
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setLogTemplateExceptions(false);
        configuration.setWrapUncheckedExceptions(true);

        resp.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));
        try (PrintWriter writer = resp.getWriter()) {
            String nameOfSamir = "Samir";
            HashMap<String, Object> data = new HashMap<>();
            data.put("name", nameOfSamir);
            configuration.getTemplate("dinamic.ftl").process(data, writer);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
}
