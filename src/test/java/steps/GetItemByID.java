package steps;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetItemByID {
    private Response response;

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "http://localhost:8081";
    }

    @When("I call the endpoint to get an item by ID {int}")
    public void i_call_the_endpoint_to_get_an_item_by_id(int itemId) {
        response = given().pathParam("itemId", itemId)
                .when().get(baseURI + "/api/items/{itemId}");
    }
    @Then("the response should have status OK")
    public void the_response_should_have_status_ok() {
        response.then().statusCode(200);
    }

    @Then("the response should contain the item with ID {int}")
    public void the_response_should_contain_the_item_with_id(Integer itemId) {

        response.then().body("id", equalTo(itemId));
    }

}
