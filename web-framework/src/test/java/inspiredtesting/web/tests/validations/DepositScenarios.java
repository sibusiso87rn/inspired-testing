package inspiredtesting.web.tests.validations;

import inspiredtesting.web.tests.pages.*;
import inspiredtesting.web.validations.UserActions;

public class DepositScenarios {

    private LandingPage landingPage   = new LandingPage();
    private UserSelectPage userSelect = new UserSelectPage();
    private DepositPage depositPage   = new DepositPage();
    private TransactionsPage transactionsPage = new TransactionsPage();
    private WithdrawPage withdrawPage = new WithdrawPage();

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

    public void clickTheTransactionsButton(){
        UserActions.click(depositPage.getBtnTransactions());
    }

    public void clickTheWithdrawButton(){
        UserActions.click(depositPage.getBtnWidthdraw());
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

    public void validateBalance(String expectedBalance){
        UserActions.validateText(withdrawPage.getRemainingBalance(expectedBalance),expectedBalance);
    }

    public void selectAccountNumber(String accountNumber){
        UserActions.selectListElementByText(depositPage.getLstAccounts(),accountNumber);
    }

    public void logOut(){
        UserActions.click(depositPage.getBtnLogOut());
    }

    public void validateTransactionAmountReflects(String expectedTransactionAmount){
        UserActions.validateText(transactionsPage.getLblTransaction(expectedTransactionAmount),expectedTransactionAmount);
    }

    public void clickTheBackButtonOnTransactionHistory(){
        UserActions.click(transactionsPage.getBtnBackButton());
    }

    public void withdrawAmount(String amount){
        UserActions.input(withdrawPage.getTxtWithdrawAmount(),amount);
        UserActions.click(withdrawPage.getBtnWithdraw());
    }


}
