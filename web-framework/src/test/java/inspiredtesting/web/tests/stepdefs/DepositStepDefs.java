package inspiredtesting.web.tests.stepdefs;

import inspiredtesting.web.tests.validations.LogOnValidations;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class DepositStepDefs {

    LogOnValidations logOnValidations = new LogOnValidations();

    @Given("The user is on the landing page")
    public void theUserIsOnTheLandingPage() throws InterruptedException {
        logOnValidations.validatePageHeader("XYZ Bank");
    }

    @And("The user selects a log on name {string}")
    public void theUserSelectsALogOnName(String userName) {

    }

    @When("The user clicks the log on button")
    public void theUserClicksTheLogOnButton() {
        logOnValidations.clickTheLogonButton();
    }
}
