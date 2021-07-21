package inspiredtesting.web.driver.local;

import inspiredtesting.web.interfaces.IWebDriverSetup;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public enum LocalDriverManager implements IWebDriverSetup {

    CHROME {
        public DesiredCapabilities getDesiredCapabilities(){
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browser", "chrome");
            //TODO Add browser version
            //capabilities.setCapability("browser_version", "");
            return capabilities;
        }

        public WebDriver getLocalWebDriverObject(DesiredCapabilities capabilities,String binaryLocation){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.merge(capabilities);
            return new ChromeDriver(options);
        }
    },
    FIREFOX {
        public DesiredCapabilities getDesiredCapabilities(){
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browser", "firefox");
            //TODO Add browser version
            //capabilities.setCapability("browser_version", "");
            return capabilities;
        }

        public WebDriver getLocalWebDriverObject(DesiredCapabilities capabilities,String binaryLocation) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--start-maximized");
            options.merge(capabilities);
            return new FirefoxDriver(options);
        }

    },
}