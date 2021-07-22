package inspiredtesting.services.tests.data;

import org.json.simple.JSONObject;
import java.util.concurrent.ThreadLocalRandom;

public class TestData {

    public static String getUser(){
        JSONObject requestParams = new JSONObject();
        requestParams.put("title", "Users");
        requestParams.put("body", "The body");
        requestParams.put("userId", Integer.toString(ThreadLocalRandom.current().nextInt(1, 1000)));
        return requestParams.toJSONString();
    }
}
