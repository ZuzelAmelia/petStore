package definitions;


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import implementations.PetStepsImplementation;
import net.thucydides.core.annotations.Steps;


public class PetStepDefs {

    @Steps
    PetStepsImplementation petStepsImplementation;

    @Given("^I set base URL for the request to the petstore$")
    public void iSetBaseURLForTheRequestToThePetstore() {
        petStepsImplementation.setBaseUrl();
    }

    @And("^I set endpoint to \"([^\"]*)\"$")
    public void iSetEndpointTo(String endpoint) throws Throwable {
        petStepsImplementation.setEndPoint(endpoint);
    }


    @And("^I set header \"([^\"]*)\" to value \"([^\"]*)\"$")
    public void iSetHeaderToValue(String headerName, String headerValue) throws Throwable {
       petStepsImplementation.setHeaderToValue(headerName, headerValue);
    }

    @And("^I set body with this information:$")
    public void iSetBodyWithThisInformation(String requestBody) {
        petStepsImplementation.setBody(requestBody);

    }

    @And("^I set operation request to \"([^\"]*)\"$")
    public void iSetOperationRequestTo(String operation) throws Throwable {
       petStepsImplementation.setOperation(operation);
    }

    @When("^I execute the request$")
    public void iExecuteTheRequest() {
        petStepsImplementation.executeRequest();
        
    }

    @Then("^the status code should be a (\\d+)$")
    public void theStatusCodeShouldBeA(int expectedStatusCode) {
        petStepsImplementation.checkStatusCode(expectedStatusCode);
        
    }

    @And("^the response json path \"([^\"]*)\" should be a valid id$")
    public void theResponseJsonPathShouldBeAValidId(String jsonPath) throws Throwable {
       petStepsImplementation.checkValidId(jsonPath);
    }

    @And("^the response json path \"([^\"]*)\" should be \"([^\"]*)\"$")
    public void theResponseJsonPathShouldBe(String jsonProperty, String value) throws Throwable {
        petStepsImplementation.checkJsonPathValue(jsonProperty, value);
    }


    @And("^the pet should be available in the store$")
    public void thePetShouldBeAvailableInTheStore() {
        petStepsImplementation.checkIfPetIsAdded();
    }



}
