package com.swagger.petstore.support;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PetStoreApiServices {

    public static final String BASE_PET_STORE_PATH = "https://petstore.swagger.io/v2";


    // This method execute the corresponding request to the endpoint
    public static Response executeRequest(RequestSpecification requestSpecification, String operation, String endPoint) {
        //Instance of the restassured.response.Response interface
        Response response;
        System.out.println("*** The operation es***: "+operation);
        System.out.println("The endpoint is: "+endPoint);
        //For each operation case we aply the corresponding method (get, post, put, delete or patch)
        switch (operation) {
            case ("GET"):
                response = requestSpecification.get(endPoint);
                break;
            case ("POST"):
                response = requestSpecification.post(endPoint);
                break;
            case ("PUT"):
                response = requestSpecification.put(endPoint);
                break;
            case ("DELETE"):
                response = requestSpecification.delete(endPoint);
                break;
            case ("PATCH"):
                response = requestSpecification.patch(endPoint);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + operation);
        }
        return response;
    }


}

