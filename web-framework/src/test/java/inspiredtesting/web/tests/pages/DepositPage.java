package inspiredtesting.web.tests.pages;

import inspiredtesting.web.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends BasePage {

    @FindBy(css = "button[ng-class='btnClass2']")
    private WebElement btnDeposit;

    @FindBy(css = "input[ng-model='amount']")
    private WebElement txtDepositAmount;

    @FindBy(css = "button[class='btn btn-default']")
    private WebElement btnDepositAmount;

    public WebElement getBtnDeposit() {
        return btnDeposit;
    }

    public WebElement getTxtDepositAmount() {
        return txtDepositAmount;
    }

    public WebElement getBtnDepositAmount() {
        return btnDepositAmount;
    }
}
