package inspiredtesting.web.validations;

import inspiredtesting.web.driver.WebDriverFactory;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class UserActions {

    private static final Logger logger
            = LoggerFactory.getLogger(UserActions.class);

    private static final int WAIT_TIME = 15;

    public static void validateText(final WebElement element,String expectedText){
        logger.info("Executing text compare Actual ["+element.getText()+"] Expecting [" + expectedText+"]");
        getFluentWait().until(ExpectedConditions.visibilityOf(element));
        assertThat(element.getText(), is(equalTo(expectedText)));
    }

    public static void click(final WebElement element) {
        try {
            logger.info("About to click on element "  + element.toString());
            getFluentWait().until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (Exception e) {
            logger.error("Failed to click on element " + e.getMessage());
            assertThat(false, is(equalTo(true)));
        }
    }

    public static void selectListElementByText(final WebElement element,String visibleText) {
        try {
            logger.info("About to click on element on the list {},element list {}"  + element.toString(),visibleText);
            getFluentWait().until(ExpectedConditions.elementToBeClickable(element));
            new Select(element).selectByVisibleText(visibleText);
        } catch (Exception e) {
            logger.error("Failed to click on element " + e.getMessage());
            assertThat(false, is(equalTo(true)));
        }
    }

    public static void input(final WebElement element, String data) {
        try {
            waitForElementEnabled(element);
            logger.debug("Sending keys to element " + element.toString());
            element.sendKeys(data);
        } catch (Exception e) {
            logger.error("Failed to input data on element :" + e.getMessage());
            assertThat(false, is(equalTo(true)));
        }
    }

    public static FluentWait getFluentWait(){
        return new FluentWait<>(WebDriverFactory.getInstance().getThreadLocalWebDriver())
                .withTimeout(Duration.ofSeconds(WAIT_TIME))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class);
    }

    public static void waitForElementEnabled(final WebElement element) {
        try {
            getFluentWait().until((ExpectedCondition<Boolean>) driver -> element.isEnabled());
            logger.info("Element is enabled" + element.isEnabled());
        } catch (Exception e) {
            logger.info(
                    e + " : " + "Timed out waiting for element: " + element);
        }
    }
}
