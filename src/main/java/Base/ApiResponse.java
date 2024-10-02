package Base;




public class ApiResponse {
	
	
	public static Response getJsonFromAPIDoc(String baseURL, String basePath) {
		Response response = given().urlEncodingEnabled(false).log().all().when().baseUri(baseURL).basePath(basePath)
				.get().then().extract().response().prettyPeek();
		return response;
	}

}
