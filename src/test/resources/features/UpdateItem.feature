Feature: Test the endpoint for updating the item

  Scenario Outline: Update an item
    Given a base URI is set to "http://localhost:8081"
    And an item with ID <id> exists
    When I call the endpoint to update the item with ID <id> and new details with name <name>
    Then the response should have status no-content 204

    Examples:
      | id  | name       |
      | 1   | "Tomate"   |
      | 2   | "Cebola"   |
      | 3   | "Alface"   |