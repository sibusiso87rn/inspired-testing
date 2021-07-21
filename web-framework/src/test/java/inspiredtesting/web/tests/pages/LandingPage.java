package inspiredtesting.web.tests.pages;

import inspiredtesting.web.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {

    @FindBy(className = "mainHeading")
    private WebElement lblMainHeading;

    @FindBy(css = "button[class='btn btn-primary btn-lg']")
    private WebElement btnLogonButton;

    public WebElement getHeading() {
        return lblMainHeading;
    }

    public WebElement getBtnLogonButton() {
        return btnLogonButton;
    }

}
