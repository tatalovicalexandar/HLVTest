package local.HLVTestApp.APITests;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GET_FindByUsername_Tests {
	
	@Test
	void GET_findByExistingUsername() {
		Response response = RestAssured.get("http://localhost:8080/users/test51");
		
		System.out.println("Respose.asString: " + response.asString());
		System.out.println("Body: " + response.getBody().asString());
		System.out.println("Status Code: " + response.getStatusCode());
		System.out.println("Status Line: " + response.getStatusLine());
		System.out.println("Content-Type: " + response.getHeader("Content-Type"));
		System.out.println("Time: " + response.getTime());

		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, HttpStatus.SC_OK);
	}
	
	@Test
	void GET_findByNonExistingUsername() {
		Response response = RestAssured.get("http://localhost:8080/users/testUsername111111111");
		
		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_NOT_FOUND);
	}

}
