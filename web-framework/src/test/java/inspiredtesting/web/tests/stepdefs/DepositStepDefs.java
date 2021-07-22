package inspiredtesting.web.tests.stepdefs;

import inspiredtesting.web.tests.validations.DepositeScenarios;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DepositStepDefs {

    DepositeScenarios depositeScenarios = new DepositeScenarios();

    @Given("The user is on the landing page")
    public void theUserIsOnTheLandingPage() {
        depositeScenarios.validatePageHeader("XYZ Bank");
    }

    @And("The user selects a log on name {string}")
    public void theUserSelectsALogOnName(String userName)  {
        depositeScenarios.selectUserOnDropDownList(userName);
    }

    @When("The user clicks the log on the customer button")
    public void theUserClicksTheLogOnButton() {
        depositeScenarios.clickTheCustomerLogonButton();
    }

    @And("The user clicks on the log on button")
    public void theUserClicksOnTheLogOnButton() {
        depositeScenarios.clickTheLogonButton();
    }

    @And("The user clicks on the deposit button")
    public void theUserClicksOnTheDepositButton() {
        depositeScenarios.clickTheDepositButton();
    }

    @And("The enters a deposit amount of {string}")
    public void theUserDepositAnAmountOf(String depositAmount) {
        depositeScenarios.enterDepositAmount(depositAmount);
    }

    @And("The user deposits the amount")
    public void theUserDeposits() {
        depositeScenarios.depositAmount();
    }

    @And("The user deposit is successful")
    public void theUserDepositIsSuccessful() {
        depositeScenarios.validateDepositSuccessful();
    }

    @Then("The user logs out")
    public void theUserLogsOut() {
        depositeScenarios.logOut();
    }

    @And("The user selects an account number {string}")
    public void theUserSelectsAnAccountNumber(String accountNumber) {
        depositeScenarios.selectAccountNumber(accountNumber);
    }

    @And("The user clicks the transaction list button")
    public void theUserClicksTheTransactionListButton() {
        depositeScenarios.clickTheTransactionsButton();
    }

    @And("The user validates that the transaction amount {string} reflects")
    public void theUserValidatesThatTheTransactionAmountReflects(String transactionAmount) {
        depositeScenarios.validateTransactionAmountReflects(transactionAmount);
    }

    @And("The user clicks on the back button in transaction history page")
    public void theUserClicksOnTheBackButtonInTransactionHistoryPage() {
        depositeScenarios.clickTheBackButtonOnTransactionHistory();
    }

    @And("The user clicks on the withdraw button")
    public void theUserClicksOnTheWithdrawButton() {
        depositeScenarios.clickTheWithdrawButton();
    }

    @And("The user withdraw an amount {string}")
    public void theUserWithdrawAnAmount(String withdrawAmount) {
        depositeScenarios.withdrawAmount(withdrawAmount);
    }


    @And("The balance reflects correctly as {string}")
    public void theBalanceReflectsCorrectlyAs(String expectedBalance) {
        depositeScenarios.validateBalance(expectedBalance);
    }
}
