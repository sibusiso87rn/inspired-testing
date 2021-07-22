package inspiredtesting.web.tests.pages;

import inspiredtesting.web.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransactionsPage extends BasePage {

    @FindBy(css = "button[ng-click='back()']")
    private WebElement btnBackButton;

    public WebElement getBtnBackButton() {
        return btnBackButton;
    }

    public WebElement getLblTransaction(String amount) {
        return driver.findElement(By.xpath("//*[text()='"+amount+"']"));
    }
}
