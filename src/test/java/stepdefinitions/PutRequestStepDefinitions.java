package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
//import io.restassured.response.Response;
import org.junit.Assert;
import pageobjects.BasePage;

import java.util.HashMap;
import java.util.Map;

public class PutRequestStepDefinitions extends BasePage {

    @Given("I send a PUT request to update the user with id {int} with email {string}, latitude {string}, and longitude {string}")
    public void iSendAPutRequestToUpdateUser(int userId, String email, String lat, String lng) {
        // Criando o corpo da requisição com os valores recebidos
        Map<String, Object> updatedData = new HashMap<>();
        updatedData.put("email", email);
        updatedData.put("lat", lat);
        updatedData.put("lng", lng);

        // Enviando a requisição PUT para atualizar o usuário
        sendPutRequest("https://jsonplaceholder.typicode.com/users/" + userId, updatedData);
    }

    @Then("I validate the status code is {int} and the updated data is email {string}, latitude {string}, and longitude {string}")
    public void iValidateTheStatusCodeIsAndCheckUpdatedData(int expectedStatusCode, String expectedEmail, String expectedLat, String expectedLng) {
        // Validando o status code
        Assert.assertEquals(expectedStatusCode, response.getStatusCode());

        // Validando se os dados foram alterados corretamente
        Map<String, String> updatedUserData = response.jsonPath().getMap("$");

        Assert.assertEquals("Updated email should match", expectedEmail, updatedUserData.get("email"));
        Assert.assertEquals("Updated latitude should match", expectedLat, updatedUserData.get("lat"));
        Assert.assertEquals("Updated longitude should match", expectedLng, updatedUserData.get("lng"));
    }
}


