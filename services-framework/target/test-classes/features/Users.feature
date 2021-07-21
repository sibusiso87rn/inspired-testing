@Dev
Feature: Compute Sum
  Background:

  Scenario: I post a new user to the typicode
    Given I POST a new user
    Then I receive a valid HTTP response code "203"

  Scenario Outline: I get a user from the users API
    Given I GET a user "<userId>"
    Then I receive a valid HTTP response code "200"
    And I validate that the username is correct "<userName>"
    Examples:
      |userId|userName|
      |   1  |  Bret  |

  Scenario: Get users from the users API
    Given I GET users from the users API
    Then I receive a valid HTTP response code "200"
    And The response has "10" users