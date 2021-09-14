package local.HLVTestApp.APITests;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import local.HLVTestApp.base.CsvDataProviders;

public class API_DeleteAllUsersTests {

	@Test(dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	void API_DeleteAllUsers(Map<String, String> testData) {
		
		// Data from data provider
		//String no = testData.get("no");
		String statusCode = testData.get("statusCode"); 
		String body = testData.get("body"); 
		//String description = testData.get("description");
		
		Response response = RestAssured.delete("http://localhost:8080/users/deleteAllUsers");
		
		// Check if status code is as expected
		Assert.assertEquals(response.getStatusCode(), Integer.parseInt(statusCode));
		
		// Check if body is as expected
		if(body.length() != 0)
			Assert.assertEquals(response.getBody().asString(), body);
	}
}
