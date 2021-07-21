package inspiredtesting.web.tests.pages;

import inspiredtesting.web.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserSelectPage extends BasePage {

    @FindBy(id = "userSelect")
    private WebElement userList;

    @FindBy(css = "button[class='btn btn-default']")
    private WebElement btnLogin;


    public WebElement getUserList() {
        return userList;
    }

    public WebElement getBtnLogin() {
        return btnLogin;
    }
}
