Feature: Test the endpoint for getting an item by ID

  Scenario Outline: Get item by ID
    Given a base URI is set to "http://localhost:8081"
    When I call the endpoint to get an item by ID <id>
    Then the response should have status OK
    And the response should contain the item with ID <id>

    Examples:
      | id  |
      | 1   |
      | 2   |
      | 3   |
