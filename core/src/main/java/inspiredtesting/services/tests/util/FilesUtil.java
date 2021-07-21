package inspiredtesting.services.tests.util;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.File;
import java.io.StringWriter;
import java.net.URL;
import java.util.Map;

public class FilesUtil {

    public static File getFile(String fileName)
    {
        ClassLoader classLoader = FilesUtil.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("File is not found!");
        } else {
            return new File(resource.getFile());
        }
    }

    public static String updateJSON(Map testData, String templateName){
        VelocityEngine velocity = new VelocityEngine();
        velocity.init();
        VelocityContext context = new VelocityContext(testData);
        org.apache.velocity.Template templateApplication = velocity.getTemplate(templateName);
        StringWriter writer = new StringWriter();
        templateApplication.merge(context,writer);
        return writer.toString();
    }
}
