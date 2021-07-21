package inspiredtesting.web.tests.validations;

import inspiredtesting.web.tests.pages.LandingPage;
import inspiredtesting.web.tests.pages.UserSelectPage;
import inspiredtesting.web.tests.pages.WelcomePage;
import inspiredtesting.web.validations.UserActions;

public class LogOnValidations {

    LandingPage landingPage   = new LandingPage();
    UserSelectPage userSelect = new UserSelectPage();
    WelcomePage welcomePage   = new WelcomePage();

    public void validatePageHeader(String expectedPageHeader){
        UserActions.validateText(landingPage.getHeading(),expectedPageHeader);
    }

    public void clickTheCustomerLogonButton(){
        UserActions.click(landingPage.getBtnLogonButton());
    }

    public void selectUserOnDropDownList(String username){
        UserActions.selectListElementByText(userSelect.getUserList(),username);
    }

    public void clickTheLogonButton(){
        UserActions.click(userSelect.getBtnLogin());
    }

    public void clickTheDepositButton(){
        UserActions.click(welcomePage.getBtnDeposit());
    }

    public void enterDepositAmount(String depositAmount){
        UserActions.input(welcomePage.getBtnDeposit(),depositAmount);
    }


}
