package FreeMarker;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class TemplateEngine {

    private final Configuration config;


    public TemplateEngine(String location) throws IOException {
        this.config = new Configuration(Configuration.VERSION_2_3_28) {{
            setDirectoryForTemplateLoading(new File(location));
            setDefaultEncoding(String.valueOf(StandardCharsets.UTF_8));
            setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            setLogTemplateExceptions(false);
            setWrapUncheckedExceptions(true);
        }};
    }

    public void render(String URL, HashMap<String, Object> data, HttpServletResponse response) {
        response.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));
        try (PrintWriter writer = response.getWriter()) {
            config.getTemplate(URL).process(data, writer);
        } catch (TemplateException | IOException x) {
            throw new RuntimeException("Freemarker error", x);
        }
    }
}
