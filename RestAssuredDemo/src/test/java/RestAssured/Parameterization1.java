package RestAssured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Parameterization1 {

	
	@DataProvider(name = "DataForTest")
	public Object[][] dataForTest()	{
						
		return new Object[][]{
			{"Manish", "Gupta", 4 },
			{"Arv", "Dev", 4 }
			
		 };
	}
	
	
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
