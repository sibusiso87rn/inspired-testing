package inspiredtesting.web.validations;

import inspiredtesting.web.driver.WebDriverFactory;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class UserActions {

    private static final Logger logger
            = LoggerFactory.getLogger(UserActions.class);

    private static final int WAIT_TIME = 15;

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

    public static void selectListElementByText(WebElement element,String visibleText) {
        try {
            logger.info("About to click on element on the list {},element list {}"  + element.toString(),visibleText);
            getFluentWait().until(ExpectedConditions.elementToBeClickable(element));
            new Select(element).selectByVisibleText(visibleText);
        } catch (Exception e) {
            logger.error("Failed to click on element " + e.getMessage());
            assertThat(false, is(equalTo(true)));
        }
    }

    public static FluentWait getFluentWait(){
        return new FluentWait<>(WebDriverFactory.getInstance().getThreadLocalWebDriver())
                .withTimeout(Duration.ofSeconds(WAIT_TIME))
            .pollingEvery(Duration.ofMillis(1000))
            .ignoring(NoSuchElementException.class);
    }
}
