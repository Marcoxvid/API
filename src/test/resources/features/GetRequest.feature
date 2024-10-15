Feature: Retrieve comment by name with GET request
  Scenario: Search for a comment by name and validate email
    Given I send a GET request to search for a comment by name "alias odio sit"
    Then I validate the status code is 200 and check the email
