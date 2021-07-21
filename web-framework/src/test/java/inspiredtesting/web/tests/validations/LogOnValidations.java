package inspiredtesting.web.tests.validations;

import inspiredtesting.web.tests.pages.LandingPage;
import inspiredtesting.web.tests.pages.UserSelectPage;
import inspiredtesting.web.validations.UserActions;

public class LogOnValidations {

    LandingPage landingPage   = new LandingPage();
    UserSelectPage userSelect = new UserSelectPage();

    public void validatePageHeader(String expectedPageHeader){
        UserActions.validateText(landingPage.getHeading(),expectedPageHeader);
    }

    public void clickTheLogonButton(){
        UserActions.click(landingPage.getLogonButton());
    }

    public void selectUserOnDropDownList(String username){
        UserActions.selectListElementByText(userSelect.getUserList(),username);
    }

}
