package Test;
import java.io.IOException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

class Test2 {

	@Test
	public void givenUserDoesNotExists_whenUserInfoIsRetrieved_then404IsReceived()
			  throws ClientProtocolException, IOException {
			 
			    // Given
			    String name = RandomStringUtils.randomAlphabetic( 8 );
				HttpUriRequest request = new HttpGet("http://localhost:8080/users/" + name);

			    // When
			    HttpResponse httpResponseNotFound = HttpClientBuilder.create().build().execute(request);

			    // Then
			    Assert.assertEquals(HttpStatus.SC_NOT_FOUND, httpResponseNotFound.getStatusLine().getStatusCode());
			}
	
	@Test
	public void givenUserExists_whenUserInfoIsRetrieved_then200IsReceived()
			  throws ClientProtocolException, IOException {
			 
			    // Given
			    String name = "Test2";
				HttpUriRequest request = new HttpGet("http://localhost:8080/users/" + name);

			    // When
			    HttpResponse httpResponseOK = HttpClientBuilder.create().build().execute(request);

			    // Then
			    Assert.assertEquals(HttpStatus.SC_OK, httpResponseOK.getStatusLine().getStatusCode());
			}
}
