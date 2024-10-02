package APiTesting;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class GetTopMenuByDeviceTest {
@Test
	public void getTopMenuDetails(ITestContext context) {
		RestAssured.baseURI="https://msapiuatfo.weyyak.com";
		HashMap<String,Object>query = new HashMap<>();
		query.put("device","web");
		Response response = given().queryParams(query).when().get("/v1/en/contenttype").then().extract().response().prettyPeek();
		/*Response response= given().queryParams(query).when().get("/v1/en/contenttype").then().extract().response().prettyPeek();
		System.out.println("Status Code of the Get Top Menu Detials By DEvice API: "+response.statusCode());
		
		String ContentType_S = response.jsonPath().getString("[0].url");
		String ContentType_M = response.jsonPath().getString("[1].url");
		System.out.println(ContentType_S);
		System.out.println(ContentType_M);
		context.setAttribute("ContentType_S", ContentType_S);
		context.setAttribute("ContentType_M", ContentType_M);*/
		
		String ContentType_S =response.jsonPath().get("[0].title"); 
		//System.out.println(response.jsonPath().getString("[0].title"));
		String ContentType_M =response.jsonPath().getString("[1].title"); 
		String ContentType_P =response.jsonPath().getString("[2].title"); 
		String ContentType_L =response.jsonPath().getString("[3].title"); 
		
		String ContentType_S_url= response.jsonPath().getString("[0].url");
		String ContentType_M_url= response.jsonPath().getString("[1].url");
		String ContentType_P_url= response.jsonPath().getString("[2].url");
		String ContentType_L_url= response.jsonPath().getString("[3].url");
		//String ContentType_S = response.jsonPath().getString("[0].url");
		
		context.setAttribute("ContentType_S", ContentType_S);
		context.setAttribute("ContentType_P", ContentType_P);
		context.setAttribute("ContentType_M", ContentType_M);
		context.setAttribute("ContentType_L", ContentType_L);
		
		context.setAttribute("ContentType_S_url", ContentType_S_url);
		context.setAttribute("ContentType_M_url", ContentType_M_url);
		context.setAttribute("ContentType_P_url", ContentType_P_url);
		context.setAttribute("ContentType_L_url", ContentType_L_url);
		
		
		System.out.println(response.statusCode());
		System.out.println(ContentType_S);
		System.out.println(ContentType_M);
		System.out.println(ContentType_P);
		System.out.println(ContentType_L);
		
		System.out.println(ContentType_S_url);
		System.out.println(ContentType_M_url);
		System.out.println(ContentType_P_url);
		System.out.println(ContentType_L_url);
		Assert.assertEquals(response.statusCode(), 200);
	}

}
