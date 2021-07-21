package inspiredtesting.web.tests.validations;

import inspiredtesting.web.tests.pages.LandingPage;
import inspiredtesting.web.validations.UserActions;

public class LogOnValidations {

    LandingPage landingPage = new LandingPage();

    public void validatePageHeader(String expectedPageHeader){
        UserActions.validateText(landingPage.getHeading(),expectedPageHeader);
    }

    public void clickTheLogonButton(){
        UserActions.click(landingPage.getLogonButton());
    }

}
