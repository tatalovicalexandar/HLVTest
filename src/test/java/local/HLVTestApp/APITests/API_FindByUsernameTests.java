package local.HLVTestApp.APITests;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import local.HLVTestApp.base.CsvDataProviders;

public class API_FindByUsernameTests {
	
	@Test(dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	void API_FindByUsername(Map<String, String> testData) {
		
		// Data from data provider
		//String no = testData.get("no");
		String username = testData.get("username");
		String statusCode = testData.get("statusCode"); 
		String bodyUsername = testData.get("bodyUsername"); 
		String bodyFirstName = testData.get("bodyFirstName"); 
		String bodyLastName = testData.get("bodyLastName"); 
		//String description = testData.get("description");
		
		Response response = RestAssured.get("http://localhost:8080/users/" + username);
		
		// Check if status code is as expected
		Assert.assertEquals(response.getStatusCode(), Integer.parseInt(statusCode));
		
		// Check if body is as expected
		if(bodyUsername.length() != 0 && bodyFirstName.length() != 0 && bodyLastName.length() != 0) {
			
			String body = response.getBody().asString();
			
			Assert.assertTrue(body.contains(bodyUsername));
			Assert.assertTrue(body.contains(bodyFirstName));
			Assert.assertTrue(body.contains(bodyLastName));
		}
	}
}
