package BackOfficeApiTesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.HashMap;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class CreateOneTierTest {
	
	
	@Test
	public void oneTierCreateTest(ITestContext context) {
		RestAssured.baseURI = "https://go-bo-uat.weyyak.com/api";
		
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
		
		//Creating one Tier
		HashMap<String,Object>Headers= new HashMap<String,Object>();
		Headers.put("Authorization", "Bearer "+access_token);
		File file= new File(".\\src\\test\\resources\\testdata\\payloads\\createOneTierPayload.json");
		Response response1=given().headers(Headers).body(file).when().post("/contents/onetier/published").then().extract().response();
		response1.prettyPeek();
		System.out.println("Status Code of the Create One Tier API: "+response.statusCode());
		String movieId = response1.jsonPath().getString("data.id");
		System.out.println("Movie Id: "+movieId);
		
	}

}
