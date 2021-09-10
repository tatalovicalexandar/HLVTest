package local.HLVTestApp.APITests;

import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POST_ValidateLogin_Tests {

	@Test
	void POST_validateSuccessfullLogin() {
		
		RestAssured.baseURI ="http://localhost:8080/users";
		RequestSpecification request = RestAssured.given();
		
		// JSONObject is a class that represents a Simple JSON.
		// We can add Key - Value pairs using the put method
		JSONObject requestParams = new JSONObject();
		requestParams.put("firstName", "testFirstName1"); 
		requestParams.put("lastName", "testLastName1");
		requestParams.put("password", "testPassword1");
		requestParams.put("username", "testUsername1");
		
		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");

		// Add the Json to the body of the request
		request.body(requestParams.toString());

		// Post the request and check the response
		Response response = request.post("/login");
		
		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
	}
	
	@Test
	void POST_validateUnsuccessfullLoginWrongUsername() {
		
		RestAssured.baseURI ="http://localhost:8080/users";
		RequestSpecification request = RestAssured.given();
		
		// JSONObject is a class that represents a Simple JSON.
		// We can add Key - Value pairs using the put method
		JSONObject requestParams = new JSONObject();
		requestParams.put("firstName", "testFirstName1"); 
		requestParams.put("lastName", "testLastName1");
		requestParams.put("password", "testPassword1");
		requestParams.put("username", "testUsername11111111");
		
		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");

		// Add the Json to the body of the request
		request.body(requestParams.toString());

		// Post the request and check the response
		Response response = request.post("/login");
		
		//Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_NOT_FOUND);
		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_EXPECTATION_FAILED);
		
		Assert.assertEquals(response.getBody().asString(), "Login failed.");
	}
}
