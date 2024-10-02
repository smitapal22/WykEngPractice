package Base;



import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class APIBaseTest {
	public static JSONObject getSchemaLocally(String schemaFileName , String schemaName) {
		String ResponseSchemaFileName;
		 String schemaFileName1=".\\src\\test\\resources\\testdata\\apiTestData\\GenerateTokenApiTest.json";
	        JSONParser jsonParser = new JSONParser();
	        FileReader fileReader = null;
	        JSONObject jsonObject3 = null;
	        try {

	            fileReader = new FileReader(schemaFileName1);
	            JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);
	            JSONObject jsonObject1 = (JSONObject) jsonObject.get("components");
	            JSONObject jsonObject2 = (JSONObject) jsonObject1.get("schemas");
	            jsonObject3 = (JSONObject) jsonObject2.get(schemaName);

	        } catch (IOException | ParseException e) {
	            e.printStackTrace();
	        }

	        System.out.println("Json object from file is "+jsonObject3.toString());

	        return jsonObject3;
	    }
	
	public static synchronized JSONObject[] getTestDataJson(String className, String key) {
        JSONObject[] arr = null;
        return arr = RestApiDataProvider.getJsonData(className, key);

    }
	  public static JSONObject getSchema(String schemaName, String endpoint) {
	        JSONObject jsonObject3 = null;
	        Response swaggerMainSchemaResp = ApiResponse.getJsonFromAPIDoc(API_DOC_BASEURL, endpoint);
	        try {
	            JSONParser jsonParser = new JSONParser();
	            JSONObject jsonObject = (JSONObject) jsonParser.parse(swaggerMainSchemaResp.asString());
	            JSONObject jsonObject1 = (JSONObject) jsonObject.get("components");
	            JSONObject jsonObject2 = (JSONObject) jsonObject1.get("schemas");
	            jsonObject3 = (JSONObject) jsonObject2.get(schemaName);

	        } catch (ParseException p) {
	            p.printStackTrace();
	        }
	        return jsonObject3;
	    }

}
