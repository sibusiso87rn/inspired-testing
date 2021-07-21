package inspiredtesting.services.data;

import inspiredtesting.services.util.FilesUtil;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class TestData {

    private final static String USER_TEMPLATE_LOCATION = "src/test/resources/velocity.templates/user";

    public static String getUser(){
        HashMap<String ,String> templateMap = new HashMap();
        templateMap.put("id",Integer.toString(ThreadLocalRandom.current().nextInt(1, 1000)));
        return FilesUtil.updateJSON(templateMap, USER_TEMPLATE_LOCATION);
    }
}
