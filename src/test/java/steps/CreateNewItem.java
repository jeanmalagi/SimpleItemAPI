package steps;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreateNewItem {
    private Response response;
    private String itemName;

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "http://localhost:8081";
    }

    @When("I call the endpoint to create a new item with name {string}")
    public void i_call_the_endpoint_to_create_a_new_item_with_name(String itemName) {

        this.itemName = itemName;

        response = given()
                .contentType("application/json")
                .body("{\"nome\":\"" + itemName + "\"}")
                .when().post(baseURI + "/api/items");
    }

    @Then("the response should have status is created")
    public void the_response_should_have_status_is_created() {
        response.then().statusCode(201);
    }

}
