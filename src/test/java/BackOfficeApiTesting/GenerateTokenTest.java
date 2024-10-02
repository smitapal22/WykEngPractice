package BackOfficeApiTesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class GenerateTokenTest {
	@Test
	public void backOfficeLoginTest() {
		
		RestAssured.baseURI="https://go-bo-uat.weyyak.com/api";
		
		HashMap<String,Object>body=new HashMap<String,Object>();
		body.put("username", "engro@engro.io");
		body.put("password", "Engro@2024");
		body.put("grant_type", "password");
		
		Response response=given().header("Contype-Type","application/x-www-form-urlencoded").formParams(body).when().post("/oauth2/token").then().extract().response();
		response.prettyPeek();
		System.out.println(response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		String access_token = response.jsonPath().getString("access_token");
		System.out.println("Access Token: "+access_token);
	
	}

}
