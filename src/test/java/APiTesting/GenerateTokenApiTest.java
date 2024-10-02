package APiTesting;

import static io.restassured.RestAssured.given;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;



import Base.APIBaseTest;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;

import io.restassured.response.Response;
import io.restassured.module.jsv.JsonSchemaValidator;
public class GenerateTokenApiTest {
	@Test
	public String generateToken() {
		RestAssured.baseURI = "https://msapiuatfo.weyyak.com";
		InputStream schemaStream = getClass().getClassLoader().getResourceAsStream("GenerateTokenApi.json");
		if (schemaStream == null) {
		    throw new IllegalArgumentException("Schema file not found!");
		}
				//"https://msapiuatfo.weyyak.com";
		// RestAssured.basePath = "/v1/oauth2/token";
		//InputStream ResponseSchemaFileName = getClass ().getClassLoader ()
			   // .getResourceAsStream ("GenerateTokenApiTest.json");
		//String ResponseSchemaFileName = ".//src//test//resources//testdata//apiTestData//GenerateTokenApiTest.json";
		HashMap<String, Object> body = new HashMap<>();
		body.put("username", "iosa50@maildrop.cc");
		body.put("password", "12345678");
		body.put("grant_type", "password");
		body.put("DeviceId", "web_app");
		body.put("DevicePlatform", "web_app");
		body.put("DeviceName", "web_app");
		//JSONObject schema =APIBaseTest.getSchemaLocally("GenerateTokenApiTest","SuccessResponse");
		Response response =  given().header("Content-Type", "application/x-www-form-urlencoded").formParams(body)
				.post("/oauth2/token");
				System.out.println("Response body: " + response.asString());
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("GenerateTokenApi.json"));	
		response.prettyPrint();
		String access_token=response.jsonPath().getString("access_token");
		System.out.println(response.jsonPath().getString("access_token"));
		System.out.println(response.jsonPath().getString("user_id"));
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200)	;
		//context.setAttribute("accessToken", access_token);
	

		

		
		       /* JSONParser jsonParser = new JSONParser();

		        try (FileReader fileReader = new FileReader(".\\src\\test\\resources\\testdata\\apiTestData\\GenerateTokenApiTest.json")) {
		            // Parse the JSON file
		            JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);

		            // Extract the "components" object
		            JSONObject components = (JSONObject) jsonObject.get("components");

		            // Extract a specific component (e.g., "component1")
		            JSONObject validUser = (JSONObject) components.get("ValidUser");
		            String access_token1 = (String) validUser.get("access_token");
		            String user_id = (String) validUser.get("user_id");

		            // Print the extracted values
		            System.out.println("Component Name: " + name);
		            System.out.println("Component Version: " + version);

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }*/
		return access_token;
	}
	
		
	}


