package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
//import io.restassured.response.Response;
import org.junit.Assert;
import pageobjects.BasePage;

public class GetRequestStepDefinitions extends BasePage {

    @Given("I send a GET request to search for a comment by name {string}")
    public void iSendAGetRequestToSearchForCommentByName(String name) {
        // Enviando a requisição GET para buscar o comentário pelo nome
        sendGetRequest("https://jsonplaceholder.typicode.com/comments?name=" + name);
    }

    @Then("I validate the status code is {int} and check the email")
    public void iValidateTheStatusCodeIsAndCheckTheEmail(int expectedStatusCode) {
        // Validando o status code
        Assert.assertEquals(expectedStatusCode, response.getStatusCode());

        // Validando o email do objeto retornado
        String email = response.jsonPath().getString("email[0]"); // Pega o email do primeiro comentário retornado
        Assert.assertNotNull("Email should not be null", email);
        
        // Imprime o email retornado
        System.out.println("Email returned: " + email);
    }
}
