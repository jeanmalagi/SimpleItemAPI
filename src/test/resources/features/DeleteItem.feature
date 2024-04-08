Feature: Test the delete item

  Scenario: Delete an item by ID
    Given an item with ID 1 exists
    When I make a request to delete the item with the specified ID
    Then the response should have status 204
