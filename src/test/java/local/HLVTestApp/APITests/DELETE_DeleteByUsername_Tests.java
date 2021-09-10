package local.HLVTestApp.APITests;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DELETE_DeleteByUsername_Tests {

	@Test
	void DELETE_DeleteByExistingUsername() {
		Response response = RestAssured.delete("http://localhost:8080/users/testUsername1");
		
		System.out.println("Body: " + response.getBody().asString());
		System.out.println("Content-Type: " + response.getHeader("Content-Type"));
		System.out.println("Content-Length: " + response.getHeader("Content-Length"));
		
		
		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
	}
	
	@Test
	void DELETE_DeleteByNonExistingUsername() {
		Response response = RestAssured.delete("http://localhost:8080/users/testUsername111111111");
		
		System.out.println("Body: " + response.getBody().asString());
		System.out.println("Content-Type: " + response.getHeader("Content-Type"));
		System.out.println("Content-Length: " + response.getHeader("Content-Length"));
		
		
		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_NOT_FOUND);
		Assert.assertEquals(response.getBody().asString(), "User doesnt exist!");
	}
}
