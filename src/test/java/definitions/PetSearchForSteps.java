package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import implementations.PetStepsImplementation;
import net.thucydides.core.annotations.Steps;

public class PetSearchForSteps {

    @Steps
    PetStepsImplementation petStepsImplementation;

    @Given("^I set base URL for search request to the petstore$")
    public void iSetBaseURLForSearchRequestToThePetstore() {
        petStepsImplementation.setBaseUrl();
        
    }

    @And("^I set endpoint for  searching \"([^\"]*)\"$")
    public void iSetEndpointForSearching(String endpoint) throws Throwable {
       petStepsImplementation.setEndPoint(endpoint);
    }

    @And("^I set header for  request \"([^\"]*)\" to value \"([^\"]*)\"$")
    public void iSetHeaderForRequestToValue(String headerName, String headerValue) throws Throwable {
        petStepsImplementation.setHeaderToValue(headerName, headerValue);

    }

    @And("^And  I set operation for searching request to \"([^\"]*)\"$")
    public void andISetOperationForSearchingRequestTo(String operation) throws Throwable {
        petStepsImplementation.setOperation(operation);
    }

    @When("^I search for the pet id$")
    public void iSearchForThePetId() {
        petStepsImplementation.executeRequest();
    }


    @Then("^the status code of search request should be a (\\d+)$")
    public void theStatusCodeOfPostSRequestShouldBeA(int expectedStatusCode) {
        petStepsImplementation.checkStatusCode(expectedStatusCode);
        
    }

    @And("^I should get the pet with the id \"([^\"]*)\"$")
    public void iShouldGetThePetWithTheId(String petId) throws Throwable {
        petStepsImplementation.getPetWithId(petId);

    }


    @When("^I search for pets with the corresponding status \"([^\"]*)\"$")
    public void iSearchForPetsWithTheCorrespondingStatus(String status) throws Throwable {
        petStepsImplementation.searchPetsByStatus(status);
    }


}
