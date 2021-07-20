package co.za.inspiredtesting.services;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * Created by Sibusiso Radebe.
 */
@CucumberOptions(
        plugin  = {
                "starter.testing.core.util.report.ExtentReportListener",
                "pretty",
                "json:target/cucumber-report.json",
        },
        features    = {"src/test/resources/features" },
        glue        = {""},
        tags        = "@Dev"
)
public class TestRunner {
        private static final Logger logger
                = LoggerFactory.getLogger(TestRunner.class);

        @Test
        public void sample(){
                logger.info("Example log from {}", "");
        }
}