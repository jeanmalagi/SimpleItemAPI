Feature: Test the endpoint for updating the item

  Scenario: Update an item
    Given a base URI is set to "http://localhost:8081"
    And an item with ID 1 exists
    When I call the endpoint to update the item with ID 1 and new details with name "Atualização de item"
    Then the response should have status no-content 204