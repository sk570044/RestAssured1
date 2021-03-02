package RestAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class Parameterization {

	@DataProvider(name = "DataForTest")
	public Object[][] dataForTest()	{
		Object[][] data=new Object[2][3];
		
		data[0][0]="Ajay";
		data[0][1]="Gupta";
		data[0][2]=1;
		
		data[1][0]="Pradeep";
		data[1][1]="Yadav";
		data[1][2]=1;
				
		return data;		
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
