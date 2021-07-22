package inspiredtesting.web.tests.pages;

import inspiredtesting.web.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DepositPage extends BasePage {

    @FindBy(css = "button[ng-class='btnClass2']")
    private WebElement btnDeposit;

    @FindBy(css = "button[ng-class='btnClass1']")
    private WebElement btnTransactions;

    @FindBy(css = "button[ng-class='btnClass3']")
    private WebElement btnWidthdraw;

    @FindBy(css = "input[ng-model='amount']")
    private WebElement txtDepositAmount;

    @FindBy(css = "button[class='btn btn-default']")
    private WebElement btnDepositAmount;

    @FindBy(css = "span[ng-show='message']")
    private WebElement lblDepositMessage;

    @FindBy(id = "accountSelect")
    private WebElement lstAccounts;

    @FindBy(css = "button[ng-show='logout']")
    private WebElement btnLogOut;

    public WebElement getBtnDeposit() {
        return btnDeposit;
    }

    public WebElement getTxtDepositAmount() {
        return txtDepositAmount;
    }

    public WebElement getBtnDepositAmount() {
        return btnDepositAmount;
    }

    public WebElement getLblDepositMessage() {
        return lblDepositMessage;
    }

    public WebElement getLstAccounts() {
        return lstAccounts;
    }

    public WebElement getBtnLogOut() {
        return btnLogOut;
    }

    public WebElement getBtnTransactions() {
        return btnTransactions;
    }

    public WebElement getBtnWidthdraw() {
        return btnWidthdraw;
    }

}
