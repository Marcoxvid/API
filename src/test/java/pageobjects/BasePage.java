//package pageobjects;
//
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//import utils.Constants;
//
//public class BasePage {
//
//    // Constructor to set the base URI
//    public BasePage() {
//        RestAssured.baseURI = Constants.BASE_URL;
//    }
//
//    // Method to send GET request
//    public Response sendGetRequest(String endpoint, String queryParamKey, String queryParamValue) {
//        RequestSpecification request = RestAssured.given();
//        request.queryParam(queryParamKey, queryParamValue);
//        return request.get(endpoint);
//    }
//
//    // Method to send POST request
//    public Response sendPostRequest(String endpoint, Object body) {
//        RequestSpecification request = RestAssured.given();
//        request.contentType("application/json");
//        request.body(body);
//        return request.post(endpoint);
//    }
//
//    // Method to send PUT request
//    public Response sendPutRequest(String endpoint, Object body) {
//        RequestSpecification request = RestAssured.given();
//        request.contentType("application/json");
//        request.body(body);
//        return request.put(endpoint);
//    }
//}

package pageobjects;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BasePage {

    protected Response response;

    // Método para enviar uma requisição GET
    public Response sendGetRequest(String endpoint) {
        response = RestAssured.given().when().get(endpoint);
        return response;
    }

    // Método para enviar uma requisição POST
    public Response sendPostRequest(String endpoint, Object body) {
        response = RestAssured.given()
            .contentType("application/json")
            .body(body)
            .when()
            .post(endpoint);
        return response;
    }

    // Método para enviar uma requisição PUT
    public Response sendPutRequest(String endpoint, Object body) {
        response = RestAssured.given()
            .contentType("application/json")
            .body(body)
            .when()
            .put(endpoint);
        return response;
    }
}
