@Dev @Users
Feature: Post New User
  Background:
    Given I set POST to the typicode service api endpoint

  Scenario: I post a new user to the typicode
    When I POST a new user
    Then I receive a valid HTTP response code "200"



