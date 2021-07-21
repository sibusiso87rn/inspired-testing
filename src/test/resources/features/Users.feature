@Dev @Users
Feature: Users API

  Scenario: I post a new user to the typicode
    Given I POST a new user
    Then I receive a valid HTTP response code "200"

  Scenario Outline: I get a user from the users end point
    Given I GET a user "<userId>"
    Then I receive a valid HTTP response code "200"
    And I validate that the username is correct "<expectedUsername>"
    Examples:
      |userId   |expectedUsername|expectedEmailAddress|
      |1       |Bret             |Sincere@april.biz   |
