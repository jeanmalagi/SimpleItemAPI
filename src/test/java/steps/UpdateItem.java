package steps;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class UpdateItem {

    private Response response;
    private Long itemId;

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "http://localhost:8081";
    }

    @And("an item with ID {int} exists")
    public void an_item_with_id_exists(Integer itemId) {

        given()
            .when()
            .get("/api/items/{itemId}", itemId)
            .then()
            .statusCode(200);
    }

    @When("I call the endpoint to update the item with ID {int} and new details with name {string}")
    public void i_call_the_endpoint_to_update_the_item_with_id_and_new_details_with_name(Integer itemId, String itemName) {
        response = given()
                .contentType("application/json")
                .body("{\"name\":\"" + itemName + "\"}")
                .when().put(baseURI + "/api/items/{itemId}", itemId);

    }

    @Then("the response should have status no-content {int}")
    public void the_response_should_have_status_no_content(Integer status) {
        response.then().statusCode(status);
    }


}
