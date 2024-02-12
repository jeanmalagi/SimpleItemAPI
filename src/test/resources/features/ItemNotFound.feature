Feature: Test the item endpoint

  Scenario: Verify the message when an item is not found
    Given a base URI is set to "http://localhost:8081"
    When I call the endpoint for a non-existent item
    Then the response should have status 404
    And the response should contain the message "Not Found"
