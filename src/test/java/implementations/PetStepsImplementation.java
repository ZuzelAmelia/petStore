package implementations;

import com.swagger.petstore.support.PetStoreApiServices;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PetStepsImplementation {

    private String endPoint;
    private String operation;
    public RequestSpecification requestSpecification = RestAssured.given();
    public Response response;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public void setBaseUrl() {
        requestSpecification.baseUri(PetStoreApiServices.BASE_PET_STORE_PATH);
    }


    public void setHeaderToValue(String headerName, String headerValue) {
        requestSpecification.header(headerName, headerValue);
    }

    public void setBody(String requestBody) {
        requestSpecification.body(requestBody);
    }

    public void executeRequest() {
        response = PetStoreApiServices.executeRequest(requestSpecification, this.getOperation(), this.getEndPoint());
    }

    public void checkStatusCode(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(expectedStatusCode, actualStatusCode);

    }


    public void checkValidId(String jsonPath) {
        long petId = response.jsonPath().getLong(jsonPath);
        System.out.println("The pet's id is: " + petId);
        Pattern pattern = Pattern.compile("\\d");
        Matcher match = pattern.matcher(String.valueOf(petId));
        Assert.assertTrue(match.lookingAt());
    }

    //This methods compares if the value of the property in the jSon returned is equals to the property's value passed as parameter in the test scenario
    public void checkJsonPathValue(String jsonProperty, String value) {
        String responseValue = response.jsonPath().getString(jsonProperty);
        System.out.println("The pet's name is: " + responseValue);
        Assert.assertEquals(value, responseValue);

    }

    public void checkIfPetIsAdded() {
        long petId = response.jsonPath().getLong("id");
        String getEndPoint = "/pet/" + petId;
        response = PetStoreApiServices.executeRequest(requestSpecification, "GET", getEndPoint);
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(200, actualStatusCode);

    }

    public void getPetWithId(String petId) {
        String getEndPoint = "/pet/" + petId;
        response = PetStoreApiServices.executeRequest(requestSpecification, "GET", getEndPoint);
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(200, actualStatusCode);
    }

    public void searchPetsByStatus(String status) {
        String getEndPoint ="/pet/findByStatus?status="+status;
        response = PetStoreApiServices.executeRequest(requestSpecification, "GET", getEndPoint);
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(200, actualStatusCode);

    }


}