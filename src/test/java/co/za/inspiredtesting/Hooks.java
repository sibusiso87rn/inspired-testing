package co.za.inspiredtesting;

import co.za.inspiredtesting.rest.RestHandler;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    private static final Logger logger
            = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void initializeTest (Scenario scenario)  {
        logger.info("Running scenario  {} ", scenario.getName());
        RestAssured.baseURI = RestHandler.BASE_PATH;
    }

}
