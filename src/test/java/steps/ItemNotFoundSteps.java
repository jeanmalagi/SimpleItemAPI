package steps;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ItemNotFoundSteps {

    private Response response;

    private Long itemId=9999L;

    @BeforeAll
    public static void setUp() {
        // RestAssured.baseURI is set in the feature file, so no need to set it here
    }

    @Given("a base URI is set to {string}")
    public void setBaseUri(String baseUri) {
        RestAssured.baseURI = baseUri;
    }

    @When("I call the endpoint for a non-existent item")
    public void callEndpointForNonExistentItem() {
        response = given().pathParam("itemId", itemId)
                .when().get("/api/{itemId}");
    }

    @Then("the response should have status 404")
    public void verifyResponseStatus404() {
        response.then().statusCode(404);
    }

    @And("the response should contain the message {string}")
    public void verifyResponseContainsMessage(String expectedMessage) {
        response.then()
                .body("error", equalTo(expectedMessage));
    }
}
