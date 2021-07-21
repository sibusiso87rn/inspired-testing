package inspiredtesting.web.tests.stepdefs;

import inspiredtesting.web.tests.validations.DepositeScenarios;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class DepositStepDefs {

    DepositeScenarios logOnValidations = new DepositeScenarios();

    @Given("The user is on the landing page")
    public void theUserIsOnTheLandingPage() throws InterruptedException {
        logOnValidations.validatePageHeader("XYZ Bank");
    }

    @And("The user selects a log on name {string}")
    public void theUserSelectsALogOnName(String userName) throws InterruptedException {
        logOnValidations.selectUserOnDropDownList(userName);
    }

    @When("The user clicks the log on the customer button")
    public void theUserClicksTheLogOnButton() {
        logOnValidations.clickTheCustomerLogonButton();
    }

    @And("The user clicks on the log on button")
    public void theUserClicksOnTheLogOnButton() {
        logOnValidations.clickTheLogonButton();
    }

    @And("The user clicks on the deposit button")
    public void theUserClicksOnTheDepositeButton() {
        logOnValidations.clickTheDepositButton();
    }

    @And("The enters a deposit amount of {string}")
    public void theUserDepositAnAmountOf(String depositAmount) {
        logOnValidations.enterDepositAmount(depositAmount);
    }

    @And("The user deposits the amount")
    public void theUserDeposits() {
        logOnValidations.depositAmount();
    }

    @And("The user deposit is successful")
    public void theUserDepositIsSuccessful() {
        logOnValidations.validateDepositSuccessful();
    }
}
