package inspiredtesting.services.tests;

import inspiredtesting.services.tests.data.RestHandler;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {

    private static final Logger logger
            = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void initializeTest (Scenario scenario)  {
        logger.info("Running scenario  {} ", scenario.getName());
        RestAssured.baseURI = RestHandler.BASE_PATH;
    }

}
