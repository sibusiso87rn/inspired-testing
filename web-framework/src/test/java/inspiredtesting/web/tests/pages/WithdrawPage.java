package inspiredtesting.web.tests.pages;

import inspiredtesting.web.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WithdrawPage extends BasePage {

    @FindBy(css = "input[ng-model='amount']")
    private WebElement txtWithdrawAmount;

    @FindBy(css = "button[class='btn btn-default']")
    private WebElement btnWithdraw;

    public WebElement getTxtWithdrawAmount() {
        return txtWithdrawAmount;
    }

    public WebElement getBtnWithdraw() {
        return btnWithdraw;
    }

    public WebElement getRemainingBalance(String expectedBalance) {
        return driver.findElement(By.xpath("//strong[@class='ng-binding' and text()='"+expectedBalance+"']"));
    }
}
