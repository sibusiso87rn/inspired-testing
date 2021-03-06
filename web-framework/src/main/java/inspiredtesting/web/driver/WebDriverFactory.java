package inspiredtesting.web.driver;


import inspiredtesting.web.driver.enums.BrowserRunEnvironment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import inspiredtesting.web.driver.local.LocalDriverManager;
import inspiredtesting.web.driver.remote.RemoteWebDriverManager;

import java.net.URL;
import java.util.Properties;

import static inspiredtesting.web.validations.UserActions.getFluentWait;

public class WebDriverFactory {

    private static final Logger logger
            = LoggerFactory.getLogger(WebDriverFactory.class);

    private static WebDriverFactory webDriverFactoryInstance     = null;
    private static final ThreadLocal<WebDriver> webDriverThreadLocal   = new ThreadLocal<>();
    private static final ThreadLocal<Properties> driverPropertiesThreadLocal = new ThreadLocal<>();


    private WebDriverFactory(){
    }

    public static WebDriverFactory getInstance(){
        if(webDriverFactoryInstance==null){
            logger.info("WebDriver factory is instance is null, creating new instance");
            webDriverFactoryInstance = new WebDriverFactory();
        }
        return webDriverFactoryInstance;
    }

    public WebDriver getThreadLocalWebDriver(){
        return webDriverThreadLocal.get();
    }

    public Properties getThreadLocalProperties(){
        return driverPropertiesThreadLocal.get();
    }

    public void quitThreadLocalWebDriver(){
        logger.debug("Quiting web driver");
        getThreadLocalWebDriver().quit();
        //Cleanup
        logger.debug("Removing driver instance");
        webDriverThreadLocal.remove();

    }

    public void removeThreadLocalProperties(){
        //Cleanup
        logger.debug("Removing properties instance");
        driverPropertiesThreadLocal.remove();
    }


    public void waitForBrowserToLoad(){
        getFluentWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='btn btn-primary btn-lg']")));
    }


    public void createThreadLocalDriver() throws Exception {

        Properties driverProperties = getThreadLocalProperties();

        logger.info("Creating Web Driver for Thread Id {}, running on {} environment",Thread.currentThread().getId(),driverProperties.getProperty("browser.run.environment").toUpperCase());
        BrowserRunEnvironment browserRunEnvironment = BrowserRunEnvironment.valueOf(driverProperties.getProperty("browser.run.environment").toUpperCase());

        WebDriver driver;
        switch (browserRunEnvironment){
            case LOCAL:
                LocalDriverManager localDriverManager = LocalDriverManager.valueOf(driverProperties.getProperty("browser").toUpperCase());
                logger.info("Creating web driver for browser {}", driverProperties.getProperty("browser"));
                DesiredCapabilities desiredCapabilities = localDriverManager.getDesiredCapabilities(driverProperties.getProperty("browser.version"));
                driver  = localDriverManager.getLocalWebDriverObject(desiredCapabilities);
                break;
            case GRID:
                logger.info("Creating remote web driver for browser {}, them remote url is {}", driverProperties.getProperty("browser"),driverProperties.getProperty("grid.remote.url"));
                RemoteWebDriverManager remoteWebDriverManager = RemoteWebDriverManager.valueOf(driverProperties.getProperty("browser").toUpperCase());
                desiredCapabilities = remoteWebDriverManager.getDesiredCapabilities(driverProperties);
                driver              = remoteWebDriverManager.getWebDriverObject(new URL(driverProperties.getProperty("grid.remote.url")), desiredCapabilities);
                break;
            default:
                logger.error("Browser enviroment not specified");
                driver = null;
        }

        //Set thread local browser
        webDriverThreadLocal.set(driver);


    }

    public void createThreadProperties(Properties driverProperties){
        //Set thread-local properties
        driverPropertiesThreadLocal.set(driverProperties);
    }


}

