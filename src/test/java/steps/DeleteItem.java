package steps;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class DeleteItem {

    private Response response;

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "http://localhost:8081";
    }

    @When("I make a request to delete the item with the specified ID")
    public void i_make_a_request_to_delete_the_item_with_the_specified_id() {


    }

}
