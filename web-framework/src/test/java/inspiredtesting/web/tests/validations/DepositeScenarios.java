package inspiredtesting.web.tests.validations;

import inspiredtesting.web.tests.pages.LandingPage;
import inspiredtesting.web.tests.pages.UserSelectPage;
import inspiredtesting.web.tests.pages.DepositPage;
import inspiredtesting.web.validations.UserActions;

public class DepositeScenarios {

    LandingPage landingPage   = new LandingPage();
    UserSelectPage userSelect = new UserSelectPage();
    DepositPage depositPage   = new DepositPage();

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
        UserActions.click(depositPage.getBtnDeposit());
    }

    public void enterDepositAmount(String depositAmount){
        UserActions.input(depositPage.getTxtDepositAmount(),depositAmount);
    }

    public void depositAmount(){
        UserActions.click(depositPage.getBtnDepositAmount());
    }

    public void validateDepositSuccessful(){
        UserActions.validateText(depositPage.getLblDepositMessage(),"Deposit Successful");
    }
}
