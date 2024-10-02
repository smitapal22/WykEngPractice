package APiTesting;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;



public class GetConfigApiTest {
	@Test
	public void getConfig() {
		RestAssured.baseURI="https://msapiuatfo.weyyak.com";
		
		Response response = given().get("/config").then().extract().response();
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
