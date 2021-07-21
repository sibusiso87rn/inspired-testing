package inspiredtesting.web.tests;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {

    private static final Logger logger
            = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void initializeTest (Scenario scenario)  {
        logger.info("Running scenario  {} ", scenario.getName());
    }

}
