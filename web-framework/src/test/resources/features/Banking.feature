@Deposit @Regression
Feature: Deposit
  Background:
    Given The user is on the landing page

  Scenario Outline: As a user I want to be able to deposit funds
    When The user clicks the log on button
    And The user selects a log on name "<logOnName>"
    Examples:
      | logOnName     |
      | Harry Potter  |

