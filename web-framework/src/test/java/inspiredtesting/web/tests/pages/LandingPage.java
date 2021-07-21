package inspiredtesting.web.tests.pages;

import inspiredtesting.web.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {

    @FindBy(className = "mainHeading")
    private WebElement mainHeading;

    @FindBy(css = "button[class='btn btn-primary btn-lg']")
    private WebElement logonButton;

    public WebElement getHeading() {
        return mainHeading;
    }

    public WebElement getLogonButton() {
        return logonButton;
    }

}
