package RestAssured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;


public class DeleteParameterization extends Testdata {
	
	@Test(dataProvider = "DataforDelete")
	public void delete(int userId)
	{
	 baseURI="http://localhost:3000/";
	 
	 when().delete("/users/"+userId).
	 then().statusCode(200);	 
	}

}
