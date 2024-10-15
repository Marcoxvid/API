Feature: Create a new user with POST request
  Scenario: Create a new user with specified details
    Given I send a POST request to create a user with name "John Doe", username "johndoe", and email "johndoe@example.com"
    Then I validate the status code is 201 and the returned user ID is present
