package Base;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class RestApiDataProvider {
	public static synchronized JSONObject[] getJsonData(String className, String key) {

        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = null;
        try {

            fileReader = new FileReader("src/test/resources/testdata/" + "/" + className + ".json");

            JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);
            JSONArray jsonArray = (JSONArray) jsonObject.get(key);
            JSONObject arr[] = new JSONObject[jsonArray.size()];
            for (int i = 0; i < jsonArray.size(); i++) {
                arr[i] = (JSONObject) jsonArray.get(i);
            }
            return arr;
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
