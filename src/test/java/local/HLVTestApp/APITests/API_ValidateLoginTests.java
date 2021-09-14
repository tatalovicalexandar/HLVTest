package local.HLVTestApp.APITests;

import java.util.Map;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import local.HLVTestApp.base.CsvDataProviders;

public class API_ValidateLoginTests {

	@Test(dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	void API_ValidateLogin(Map<String, String> testData) {
		
		// Data from data provider
		//String no = testData.get("no");
		String firstName = testData.get("firstName");
		String lastName = testData.get("lastName");
		String username = testData.get("username");
		String password = testData.get("password");
		String statusCode = testData.get("statusCode"); 
		String body = testData.get("body"); 
		//String description = testData.get("description");
		
		RestAssured.baseURI ="http://localhost:8080";
		RequestSpecification request = RestAssured.given();
		
		// JSONObject is a class that represents a Simple JSON.
		// We can add Key - Value pairs using the put method
		JSONObject requestParams = new JSONObject();
		requestParams.put("firstName", firstName); 
		requestParams.put("lastName", lastName);
		requestParams.put("password", password);
		requestParams.put("username", username);
		
		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");

		// Add the Json to the body of the request
		request.body(requestParams.toString());

		// Post the request and check the response
		Response response = request.post("/users/login");
		
		// Check if status code is as expected
		Assert.assertEquals(response.getStatusCode(), Integer.parseInt(statusCode));
		
		// Check if body is as expected
		if(body.length() != 0)
			Assert.assertEquals(response.getBody().asString(), body);
	}
}
