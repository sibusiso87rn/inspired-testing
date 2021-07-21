package inspiredtesting.web.validations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class UserActions {

    private static final Logger logger
            = LoggerFactory.getLogger(UserActions.class);

    public static void validateText(WebElement element,String expectedText){
        logger.info("Executing text compare Actual ["+element.getText()+"] Expecting [" + expectedText+"]");
        assertThat(element.getText(), is(equalTo(expectedText)));
    }

    public static void click(WebElement element) {
        try {
            logger.info("About to click on element "  + element.toString());
            element.click();
        } catch (Exception e) {
            logger.error("Failed to click on element " + e.getMessage());
            assertThat(false, is(equalTo(true)));
        }
    }

}
