package inspiredtesting.web.tests;

import inspiredtesting.reports.CucumberReport;
import inspiredtesting.web.driver.WebDriverFactory;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.util.Properties;

@CucumberOptions(
        plugin  = {
                "inspiredtesting.web.report.ExtentReportListener",
                "pretty",
                "json:target/cucumber-report.json",
        },
        features    = {"src/test/resources/features" },
        glue        = {""},
        tags        = "@Regression"
)
public class WebTestRunner {


    private TestNGCucumberRunner testNGCucumberRunner;
    private static final Logger logger
            = LoggerFactory.getLogger(WebTestRunner.class);


    @BeforeClass(alwaysRun = true)
    @Parameters({"browser.version","browser","browser.run.environment"})
    public void setTestNGProperties(String browserVersion,String browser,String browserRunEnvironment) throws Exception{

        WebDriverFactory.getInstance().createThreadProperties(getTestProperties(browserVersion,browser,browserRunEnvironment));
    }

    @BeforeClass(alwaysRun = true)
    public void setUpClass(){
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber scenarios", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickleEvent, FeatureWrapper cucumberFeature) throws Throwable {
        testNGCucumberRunner.runScenario(pickleEvent.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
    }

    @AfterTest
    public void quitDriver() {
        logger.info("Quitting thread driver for scenario");
    }

    private Properties getTestProperties(String browserVersion,String browser,String browserRunEnvironment){
        Properties props = new Properties();
        props.setProperty("browser.version",browserVersion);
        props.setProperty("browser",browser);
        props.setProperty("browser.run.environment",browserRunEnvironment);
        return props;
    }

}
