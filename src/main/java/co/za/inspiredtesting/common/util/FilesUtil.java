package co.za.inspiredtesting.web.util;

import java.io.File;
import java.net.URL;

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
}
