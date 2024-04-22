Feature: Test the create item

  Scenario Outline: Create an item
    Given a base URI is set to "http://localhost:8081"
    When I call the endpoint to create a new item with name <name>
    Then the response should have status 201

    Examples:
      | name       |
      | "Queijo"   |
      | "Frango"   |
      | "Feijão"   |