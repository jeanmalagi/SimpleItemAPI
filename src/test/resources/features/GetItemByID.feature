Feature: Test the endpoint for getting an item by ID

  Scenario: Get item by ID
    Given a base URI is set to "http://localhost:8081"
    When I call the endpoint to get an item by ID 1
    Then the response should have status OK
    And the response should contain the item with ID 1
