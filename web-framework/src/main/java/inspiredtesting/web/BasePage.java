package inspiredtesting.web;

import inspiredtesting.web.driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BasePage {

    protected final WebDriver driver;
    private static final Logger logger
            = LoggerFactory.getLogger(BasePage.class);

    public BasePage(){
        driver = WebDriverFactory.getInstance().getThreadLocalWebDriver();
        logger.info("Creating page object ["+this.getClass().getSimpleName()+"]");
        PageFactory.initElements(driver,this);
    }

    protected WebDriver getDriver(){
        return driver;
    }

}
