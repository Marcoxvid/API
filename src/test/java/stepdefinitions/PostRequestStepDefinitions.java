package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
//import io.restassured.response.Response;
import org.junit.Assert;
import pageobjects.BasePage;

import java.util.HashMap;
import java.util.Map;

public class PostRequestStepDefinitions extends BasePage {

    @Given("I send a POST request to create a user with name {string}, username {string}, and email {string}")
    public void iSendAPostRequestToCreateAUser(String name, String username, String email) {
        // Criando o corpo da requisição com os valores recebidos
        Map<String, Object> userData = new HashMap<>();
        userData.put("name", name);
        userData.put("username", username);
        userData.put("email", email);

        // Enviando a requisição POST para criar o usuário
        sendPostRequest("https://jsonplaceholder.typicode.com/users", userData);
    }

    @Then("I validate the status code is {int} and the returned user ID is present")
    public void iValidateTheStatusCodeIsAndCheckUserId(int expectedStatusCode) {
        // Validando o status code
        Assert.assertEquals(expectedStatusCode, response.getStatusCode());

        // Validando se o ID do usuário retornado não é nulo
        Integer userId = response.jsonPath().getInt("id");
        Assert.assertNotNull("User ID should not be null", userId);
        
        // Imprime o ID do usuário retornado
        System.out.println("User created successfully with ID: " + userId);
    }
}
