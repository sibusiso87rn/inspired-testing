package inspiredtesting.web.tests.stepdefs;

import inspiredtesting.web.tests.validations.DepositScenarios;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DepositStepDefs {

    private DepositScenarios depositScenarios = new DepositScenarios();

    @Given("The user is on the landing page")
    public void theUserIsOnTheLandingPage() {
        depositScenarios.validatePageHeader("XYZ Bank");
    }

    @And("The user selects a log on name {string}")
    public void theUserSelectsALogOnName(String userName)  {
        depositScenarios.selectUserOnDropDownList(userName);
    }

    @When("The user clicks the log on the customer button")
    public void theUserClicksTheLogOnButton() {
        depositScenarios.clickTheCustomerLogonButton();
    }

    @And("The user clicks on the log on button")
    public void theUserClicksOnTheLogOnButton() {
        depositScenarios.clickTheLogonButton();
    }

    @And("The user clicks on the deposit button")
    public void theUserClicksOnTheDepositButton() {
        depositScenarios.clickTheDepositButton();
    }

    @And("The enters a deposit amount of {string}")
    public void theUserDepositAnAmountOf(String depositAmount) {
        depositScenarios.enterDepositAmount(depositAmount);
    }

    @And("The user deposits the amount")
    public void theUserDeposits() {
        depositScenarios.depositAmount();
    }

    @And("The user deposit is successful")
    public void theUserDepositIsSuccessful() {
        depositScenarios.validateDepositSuccessful();
    }

    @Then("The user logs out")
    public void theUserLogsOut() {
        depositScenarios.logOut();
    }

    @And("The user selects an account number {string}")
    public void theUserSelectsAnAccountNumber(String accountNumber) {
        depositScenarios.selectAccountNumber(accountNumber);
    }

    @And("The user clicks the transaction list button")
    public void theUserClicksTheTransactionListButton() {
        depositScenarios.clickTheTransactionsButton();
    }

    @And("The user validates that the transaction amount {string} reflects")
    public void theUserValidatesThatTheTransactionAmountReflects(String transactionAmount) {
        depositScenarios.validateTransactionAmountReflects(transactionAmount);
    }

    @And("The user clicks on the back button in transaction history page")
    public void theUserClicksOnTheBackButtonInTransactionHistoryPage() {
        depositScenarios.clickTheBackButtonOnTransactionHistory();
    }

    @And("The user clicks on the withdraw button")
    public void theUserClicksOnTheWithdrawButton() {
        depositScenarios.clickTheWithdrawButton();
    }

    @And("The user withdraw an amount {string}")
    public void theUserWithdrawAnAmount(String withdrawAmount) {
        depositScenarios.withdrawAmount(withdrawAmount);
    }


    @And("The balance reflects correctly as {string}")
    public void theBalanceReflectsCorrectlyAs(String expectedBalance) {
        depositScenarios.validateBalance(expectedBalance);
    }
}
