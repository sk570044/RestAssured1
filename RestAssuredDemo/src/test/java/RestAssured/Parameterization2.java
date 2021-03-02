package RestAssured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Parameterization2 extends Testdata {

	@Test(dataProvider = "DataForTest")
	public void postRequest(String FirstName, String LastName,int SubjectID)
	{
	
	JSONObject request=new JSONObject();
	request.put("FirstName", FirstName);
	request.put("LastName", LastName);
	request.put("SubjectID", SubjectID);
		
	 baseURI="http://localhost:3000/";
	 given().
	 contentType(ContentType.JSON).
	 accept(ContentType.JSON).
	 header("Content-Type", "application/json").
	 body(request.toJSONString()).
	 when().
	 post("/users/").
	 then().
	 statusCode(201);
	}
	
}
