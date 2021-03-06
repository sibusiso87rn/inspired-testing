package inspiredtesting.services.tests;

import inspiredtesting.reports.CucumberReport;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

/**
 * Created by Sibusiso Radebe.
 */
@CucumberOptions(
        plugin  = {
                "pretty",
                "json:target/cucumber-report.json",
        },
        features    = {"src/test/resources/features" },
        glue        = {""},
        tags        = "@Regression"
)
public class ServicesTestRunner {

        private TestNGCucumberRunner testNGCucumberRunner;
        private static final Logger logger
                = LoggerFactory.getLogger(ServicesTestRunner.class);

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

        @AfterSuite(alwaysRun = true)
        public void tearCreateReport() {
                //Create and finalize the report - This is done once, only after the tests have been completed.
                new CucumberReport().createReport();
        }

}