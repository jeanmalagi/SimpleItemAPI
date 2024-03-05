Feature: Test the create item

  Scenario: Create an item
    Given a base URI is set to "http://localhost:8081"
    When I call the endpoint to create a new item with name "Item teste"
    Then the response should have status 201