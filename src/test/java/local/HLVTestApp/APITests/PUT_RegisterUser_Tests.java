package local.HLVTestApp.APITests;

import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PUT_RegisterUser_Tests {

	@Test
	void PUT_successfullyRegisterUser() {
		
		RestAssured.baseURI ="http://localhost:8080/users/register";
		RequestSpecification request = RestAssured.given();
		
		// JSONObject is a class that represents a Simple JSON.
		// We can add Key - Value pairs using the put method
		JSONObject requestParams = new JSONObject();
		requestParams.put("firstName", "testFirstName11"); 
		requestParams.put("lastName", "testLastName11");
		requestParams.put("password", "testPassword11");
		requestParams.put("username", "testUsername11");
		
		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");

		// Add the Json to the body of the request
		request.body(requestParams.toString());

		// Post the request and check the response
		//Response response = request.post("/register");
		Response response = request.post("");
		
		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
	}
	
	@Test
	void PUT_unSuccessfullyRegisterUser() {
		
		RestAssured.baseURI ="http://localhost:8080/users/register";
		RequestSpecification request = RestAssured.given();
		
		// JSONObject is a class that represents a Simple JSON.
		// We can add Key - Value pairs using the put method
		JSONObject requestParams = new JSONObject();
		requestParams.put("firstName", "testFirstName11"); 
		requestParams.put("lastName", "testLastName11");
		requestParams.put("password", "testPassword11");
		requestParams.put("username", "testUsername11");
		
		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");

		// Add the Json to the body of the request
		request.body(requestParams.toString());

		// Post the request and check the response
		//Response response = request.post("/register");
		Response response = request.post("");
		
		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_NOT_FOUND);
		
		Assert.assertEquals(response.getBody().asString(), "User with the specified username already exists!");
	}
}
