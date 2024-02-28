Feature: Test the item list endpoint

  Scenario: Verify the retrieval of a list of items
    Given a base URI is set to "http://localhost:8081"
    When I call the endpoint to list items
    Then the response should have status 200
    And the response should contain a list of items
