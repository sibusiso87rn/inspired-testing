package inspiredtesting.services.stepdefs;

import inspiredtesting.services.data.TestData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class APIStepDefs {

    private RequestSpecification request = null;
    private Response response = null;
    private JsonPath jsonPathEvaluator = null;

    private static final Logger logger
            = LoggerFactory.getLogger(APIStepDefs.class);

    @When("I POST a new user")
    public void iPOSTANewUser() {
        String userRequest = TestData.getUser();
        logger.debug("Using test data {}",userRequest);
        request = RestAssured.given();
        request.header("Content-Type", "application/json; charset=UTF-8");
        request.body(userRequest);
        response = request.post("/posts");
        logger.debug(response.prettyPrint());
    }

    @Then("I receive a valid HTTP response code {string}")
    public void iReceiveAValidHTTPResponseCode(String expectedStatusCode) {
        // Assert that correct status code is returned.
        Assert.assertEquals(response.getStatusCode(), Integer.parseInt(expectedStatusCode));
    }

    @Given("I GET a user {string}")
    public void iGETAUser(String userId) {
        request  = RestAssured.given();
        response = request.get("users/"+userId);
    }

    @And("I validate that the username is correct {string}")
    public void iValidateThatTheUsernameIsCorrect(String expectedUsername) {
        jsonPathEvaluator = response.jsonPath();
        Assert.assertEquals(jsonPathEvaluator.get("username"),expectedUsername);
    }

    @Given("I GET users from the users API")
    public void iGETUsersFromTheUsersAPI() {
        request  = RestAssured.given();
        response = request.get("users");
    }

    @And("The response has {string} users")
    public void theResponseHasUsers(String expectedNumberOfUsers) {
        jsonPathEvaluator = response.jsonPath();
        Assert.assertEquals(Integer.parseInt(expectedNumberOfUsers),response.jsonPath().getList("$").size());
    }

}
