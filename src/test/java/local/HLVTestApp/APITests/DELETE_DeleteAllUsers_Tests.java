package local.HLVTestApp.APITests;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DELETE_DeleteAllUsers_Tests {

	@Test
	void DELETE_DeleteAllUsers() {
		Response response = RestAssured.delete("http://localhost:8080/users/deleteAllUsers");
		
		System.out.println("Body: " + response.getBody().asString());
		System.out.println("Content-Type: " + response.getHeader("Content-Type"));
		System.out.println("Content-Length: " + response.getHeader("Content-Length"));
		
		
		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
		
		Assert.assertEquals(response.getBody().asString(), "All users removed");
	}
}
