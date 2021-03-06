package inspiredtesting.web.tests;

import inspiredtesting.web.driver.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.UUID;

public class Hooks {

    private static final Logger logger
            = LoggerFactory.getLogger(Hooks.class);


    //TODO make this a config
    String baseUrl = "http://www.way2automation.com/angularjs-protractor/banking/#/login";

    @After
    public void afterScenario(Scenario scenario) {
        logger.info("------------------------------");
        logger.info(scenario.getName() + " - Status - " + scenario.getStatus());
        logger.info("------------------------------");
        takeScreenshot(scenario);
        WebDriverFactory.getInstance().getThreadLocalWebDriver().quit();
    }

    @Before
    public void beforeScenario(Scenario scenario) throws Exception {
        logger.info("------------------------------");
        logger.info(scenario.getName() + " - Status - " + scenario.getStatus());
        logger.info("------------------------------");

        WebDriverFactory.getInstance().createThreadLocalDriver();
        WebDriverFactory.getInstance().getThreadLocalWebDriver().navigate().to(baseUrl);
        WebDriverFactory.getInstance().waitForBrowserToLoad();

    }

    //If there is a need to take a screenshot after each step :(
    @AfterStep
    public void takeScreenshotAfterStep(Scenario scenario) {
        takeScreenshot(scenario);
    }

    private void takeScreenshotOnFailure(Scenario scenario){
        logger.info("Taking screenshot IF Test Failed");
        if (scenario.isFailed()) {
            takeScreenshot(scenario);
        }
    }

    private void takeScreenshot(Scenario scenario) {
        logger.info("Taking screenshot for scenario [{}]",scenario.getName());
        try {
            byte[] screenShot = ((TakesScreenshot) WebDriverFactory.getInstance().getThreadLocalWebDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot,"image/png", UUID.randomUUID().toString().replace("-","")+".png");
        } catch (Exception e) {
            logger.error("Failed to take screenshot , {}", e.getMessage());
        }
    }

}
