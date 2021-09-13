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
		
		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
		Assert.assertEquals(response.getBody().asString(), "User with username test51 is removed");
	}
	
	@Test
	void DELETE_DeleteByNonExistingUsername() {
		Response response = RestAssured.delete("http://localhost:8080/users/testUsername111111111");
			
		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_NOT_FOUND);
		Assert.assertEquals(response.getBody().asString(), "User doesnt exist!");
	}
}
