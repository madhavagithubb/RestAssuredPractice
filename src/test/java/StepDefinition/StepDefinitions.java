package StepDefinition;

import java.io.IOException;
import java.net.URI;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import apimethods.ApiMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	ApiMethods am = new ApiMethods();
	static String baseurl = "https://petstore.swagger.io/v2";
   
	
	@Given("prepare the api with Http Method {string}")
	public void prepare_the_api_with_http_method(String httpmethod) throws InvalidFormatException, IOException {
		System.out.println(httpmethod+" method is Executing");
		ApiMethods.setupUrl(httpmethod);
	}

	@When("execute the request")
	public void execute_the_request() {
		System.out.println("When Step Executed");
	}

	@Then("validate the Response")
	public void validate_the_response() {
		ApiMethods.ValidateResponse();
	}
	
	@Then("validate the Response status code {string}")
	public void validate_the_response_status_code(String  code) {
		int Statuscode = Integer.parseInt(code);
		ApiMethods.ValidateResponse(Statuscode);
	}

	
}
