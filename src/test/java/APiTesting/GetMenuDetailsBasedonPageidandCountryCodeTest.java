package APiTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class GetMenuDetailsBasedonPageidandCountryCodeTest {
@Test
	public void getMenuDetails() {
	HashMap<String,Object>query=new HashMap<>();
	query.put("cascade", 2);
	query.put("Country", "in");
		RestAssured.baseURI="https://msapiuatfo.weyyak.com";
		Response response = given().queryParams(query).when().get("/v1/ar/menu/62").then().extract().response();
		System.out.println(response.prettyPrint());
		String id=response.jsonPath().getString("data.playlists[0].id");
		System.out.println(response.jsonPath().getString("data.playlists[0].id"));
		System.out.println(response.getStatusCode());
		Assert.assertEquals(id, "264");
		
			}
}
