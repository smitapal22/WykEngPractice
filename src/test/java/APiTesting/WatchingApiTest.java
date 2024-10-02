package APiTesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import ApiPojos.Content;
import ApiPojos.Watching;



public class WatchingApiTest {
	/*private GenerateTokenApiTest generateTokenApiTest;

    public WatchingApiTest() {
        this.generateTokenApiTest = new GenerateTokenApiTest();
    }*/
	public static String access_token;
	
	@Test
	public void watchingApi() {
		
		RestAssured.baseURI = "https://msapiuatfo.weyyak.com";
		// RestAssured.basePath = "/v1/oauth2/token";

		HashMap<String, Object> body = new HashMap<>();
		body.put("username", "iosa50@maildrop.cc");
		body.put("password", "12345678");
		body.put("grant_type", "password");
		body.put("DeviceId", "web_app");
		body.put("DevicePlatform", "web_app");
		body.put("DeviceName", "web_app");
		Response response = given().header("Content-Type", "application/x-www-form-urlencoded").formParams(body)
				.post("/v1/oauth2/token");	
		response.prettyPrint();
		access_token = response.jsonPath().get("access_token").toString();
		
		System.out.println("Status Code Login API: "+response.statusCode());
		//context.setAttribute("access_token", access_token);
		System.out.println(access_token);
		//String accessToken = generateTokenApiTest.generateToken();
		System.out.println("access token accessed in watching api: "+access_token);
		
		
		Content content = new Content();
		content.setId(233440);
		content.setTitle("Locman");
		content.setContentType("movie");
		content.setDuration(5300);
		
		Watching watching= new Watching();
		watching.setContent(content);
		watching.setLastWatchPosition(108);
		watching.setWatchSessionId("YMUZMJUWYZETMWRJOC01NZJKLWE3M2ETNWQ1OTK5ZWE2NZC4_1727248368364");
		watching.setUser_id("25f653fc-13cd-4fc2-af9e-edfa3d85c99c");	
		watching.setDeviceId("web");
		List<String>genres = new ArrayList<String>();
		genres.add("Social");
		genres.add("Drama");
		genres.add("Comedy");
		System.out.println("first genre: "+genres.toArray()[0]);
		
		//RestAssured.baseURI="https://msapifo.weyyak.z5.com";
		
		//Object access_token =context.getAttribute("access_token");
		HashMap<String, Object> Headers = new HashMap<>();
		Headers.put("Authorization","Bearer "+access_token);
		System.out.println("access token in headers: "+Headers);
		
		Response response1 = given().headers(Headers).body(watching).when().post("/v1/contents/watching").then().extract().response().prettyPeek();
		System.out.println("response of watching api: "+response1.prettyPrint());
		System.out.println("pojo body passed: "+response1.getBody().asString());
		System.out.println("body"+watching.toString());
		System.out.println(response1.statusCode());
		Assert.assertEquals(response1.statusCode(), 200);
		
	}
	
}
