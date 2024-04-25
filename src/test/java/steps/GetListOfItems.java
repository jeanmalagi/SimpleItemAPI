package steps;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

public class GetListOfItems {

    private String baseUri;
    private Response response;

    private Long itemId;

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "http://localhost:8081";
    }

    @When("I call the endpoint to list items")
    public void i_call_the_endpoint_to_list_items() {
        response = given()
                .when().get("/api/items");
    }

    @Then("the response should is OK")
    public void the_response_should_is_ok() {
        response.then().statusCode(200);
    }

    @And("the response should contain a list of items")
    public void the_response_should_contain_a_list_of_items() {
        response.then().body("items", hasSize(greaterThan(0)));
    }

}
