@Deposit @Regression
Feature: Deposit
  Background:
    Given The user is on the landing page

  Scenario Outline: As a user I want to be able to deposit funds
    When The user clicks the log on the customer button
    And The user selects a log on name "<logOnName>"
    And The user clicks on the log on button
    And The user clicks on the deposit button
    And The enters a deposit amount of "<depositAmount>"
    And The user deposits the amount
    And The user deposit is successful
    Examples:
      | logOnName     |depositAmount|
      | Harry Potter  |100          |

