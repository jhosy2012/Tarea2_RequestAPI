package Cucumber;


import clientAPI.FactoryRequest;
import clientAPI.RequestInfo;
import clientAPI.ResponseInfo;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpres.JsonHelper;
import org.json.JSONException;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static Configuration.Configuration.*;


public class MyStepdefs {
    ResponseInfo response = new ResponseInfo();
    Map<String, String> variables = new HashMap<>();


    @Given("^I have authentication to todo\\.ly$")
    public void iHaveAuthenticationToTodoLy() {
    }

    @When("^I send (POST|PUT|DELETE|GET) request '(.*)' with json$")
    public void iSendPOSTRequestApiProjectsJsonWithJson(String method, String url, String jsonBody) {
        RequestInfo request = new RequestInfo();
        request.setUrl(HOST + this.replaceVariables(url));
        request.setBody(this.replaceVariables(jsonBody));
        request.addHeaders(BASIC_AUTHENTICATION_HEADER, BASIC_AUTHENTICATION);

        response = FactoryRequest.make(method.toLowerCase()).send(request);
    }

    @Then("^I expected the response code (\\d+)$")
    public void iExpectedTheResponseCode(int expectedResponseCode) {
        System.out.println("Response Code " + response.getResponseCode());
        Assert.assertEquals("ERROR !! the response code es incorrecto", expectedResponseCode, response.getResponseCode());
    }

    @And("^I expected the response body es equal$")
    public void iExpectedTheResponseBodyIsEqual(String expectedResponseBody) throws JSONException {
        System.out.println("Response Body " + this.replaceVariables(response.getResponseBody()));
        Assert.assertTrue("ERROR el response body es incorrecto", JsonHelper.areEqualJSON(this.replaceVariables(expectedResponseBody), response.getResponseBody()));
    }

    @And("^I get the property value '(.*)' and save on (.*)$")
    public void iGetThePropertyValueIdAndSaveOnID_PROJECT(String property, String nameVariable) throws JSONException {
        String value = JsonHelper.getValueFromJSON(response.getResponseBody(), property);
        variables.put(nameVariable, value);
        System.out.println(" varaible : " + nameVariable + " value : " + variables.get(nameVariable));
    }

    private String replaceVariables(String value) {
        for (String key : this.variables.keySet()
        ) {
            value = value.replace(key, this.variables.get(key));
        }
        return value;
    }
}