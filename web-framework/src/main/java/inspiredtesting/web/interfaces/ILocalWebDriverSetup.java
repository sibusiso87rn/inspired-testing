package inspiredtesting.web.interfaces;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface ILocalWebDriverSetup {
    WebDriver getLocalWebDriverObject(DesiredCapabilities desiredCapabilitie);
    DesiredCapabilities getDesiredCapabilities();
}