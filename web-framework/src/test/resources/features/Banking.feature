@Dev
Feature: Deposit
  Background:
    Given The user is on the landing page

  Scenario Outline: As a user I want to be able to deposit funds
    And The user selects a log on name "<logOnName>"
    Examples:
      | logOnName |
      |    name   |

