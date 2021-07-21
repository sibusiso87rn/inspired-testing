package inspiredtesting.web.driver.local;

import inspiredtesting.web.interfaces.ILocalWebDriverSetup;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public enum LocalDriverManager implements ILocalWebDriverSetup {

    CHROME {
        public DesiredCapabilities getDesiredCapabilities(String browserVersion){
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browser", "chrome");
            capabilities.setCapability("browser_version", browserVersion);
            return capabilities;
        }

        public WebDriver getLocalWebDriverObject(DesiredCapabilities capabilities){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.merge(capabilities);
            return new ChromeDriver(options);
        }
    },
    FIREFOX {
        public DesiredCapabilities getDesiredCapabilities(String browserVersion){
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browser", "firefox");
            capabilities.setCapability("browser_version", browserVersion);
            return capabilities;
        }

        public WebDriver getLocalWebDriverObject(DesiredCapabilities capabilities) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--start-maximized");
            options.merge(capabilities);
            return new FirefoxDriver(options);
        }
    }
}