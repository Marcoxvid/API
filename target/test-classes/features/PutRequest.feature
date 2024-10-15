Feature: Update user information with PUT request
  Scenario: Update a user with ID 5
    Given I send a PUT request to update the user with id 5 with email "updatedemail@example.com", latitude "-45.0", and longitude "122.1"
    Then I validate the status code is 200 and the updated data is email "updatedemail@example.com", latitude "-45.0", and longitude "122.1"
