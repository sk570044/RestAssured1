package RestAssured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Example2 {
	@Test
	public void testGet03()
	{
		
		JSONObject request=new JSONObject();
		request.put("FirstName", "Tom");
		request.put("LastName", "Cruide");
		request.put("SubjectID", 1);
		
	 baseURI=  "http://localhost:3000";
	  given().contentType(ContentType.JSON).
	         accept(ContentType.JSON).
	  		 header("Content-Type", "application/json").
	  		 body(request.toJSONString()).
	  when().
	  			post("/users").
	  then().
	  		statusCode(201).
	  		log().all();
	 
	}
}
