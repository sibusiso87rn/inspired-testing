@Deposit @Regression
Feature: Deposit
  Background:
    Given The user is on the landing page

  Scenario Outline: As a user I want to be able to deposit funds on the first account
    When The user clicks the log on the customer button
    And The user selects a log on name "<logOnName>"
    And The user clicks on the log on button
    And The user clicks on the deposit button
    And The enters a deposit amount of "<depositAmount>"
    And The user deposits the amount
    And The user deposit is successful
    Then The user logs out
    Examples:
      | logOnName     |depositAmount|
      | Harry Potter  |1500         |


  Scenario Outline: As a user I want to be able to deposit funds on multiple accounts
    When The user clicks the log on the customer button
    And The user selects a log on name "<logOnName>"
    And The user clicks on the log on button
    And The user selects an account number "<accountNumber>"
    And The user clicks on the deposit button
    And The enters a deposit amount of "<depositAmount>"
    And The user deposits the amount
    And The user deposit is successful
    Then The user logs out
    Examples:
      | logOnName     |depositAmount|accountNumber|
      | Harry Potter  |1500         |1004         |
      | Harry Potter  |1500         |1005         |
      | Harry Potter  |1500         |1006         |
