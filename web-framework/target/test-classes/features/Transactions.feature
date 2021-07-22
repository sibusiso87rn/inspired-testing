@Transactions @Regression
Feature: Transactions
  Background:
    Given The user is on the landing page

  Scenario Outline: As a user I want to be able to deposit funds and validate the deposit
    When The user clicks the log on the customer button
    And The user selects a log on name "<logOnName>"
    And The user clicks on the log on button
    And The user clicks on the deposit button
    And The enters a deposit amount of "<depositAmount>"
    And The user deposits the amount
    And The user deposit is successful
    And The user clicks the transaction list button
    And The user validates that the transaction amount "<depositAmount>" reflects
    And The user clicks on the back button in transaction history page
    And The user clicks on the withdraw button
    And The user withdraw an amount "<withdrawAmount>"
    And The balance reflects correctly as "<expectedBalance>"
    Examples:
      | logOnName     |depositAmount|withdrawAmount|expectedBalance|
      | Harry Potter  |31459        |     31459    | 0             |