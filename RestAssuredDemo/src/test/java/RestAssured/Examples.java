package RestAssured;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Examples {
	
	//@Test
	public void testGet()
	{
	 baseURI="http://localhost:3000/";
	 given().
	 get("/users").
	 then().
	 statusCode(200).and().log().all();
	 
	}

	
	//@Test
	public void testGet01()
	{
	 baseURI="http://localhost:3000/";
	 given().
	 get("/users?SubjectID=1").
	 then().
	 statusCode(200).and().log().all();
	 
	}
	
	//@Test
	public void testGet02()
	{
	 baseURI="http://localhost:3000/";
	 given().
	 param("Name", "Automation").
	 get("/Subjects").
	 then().
	 statusCode(200).and().log().all();
	 
	}
	//@Test
	public void postRequest()
	{
		
		
	JSONObject request=new JSONObject();
	request.put("FirstName", "Suraj");
	request.put("LastName", "Kumar");
	request.put("SubjectID", 1);
	
	
	
	//If you enable below line and run with unique id it will post successfully. 
	//post that you will get 500 internal server error duplicate id
	//request.put("id", 8);
		
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
	
	//@Test
	public void delete()
	{
	 baseURI="http://localhost:3000/";
	 when().delete("/users/5").
	 then().statusCode(200);	 
	}
	
	//@Test
	public void PatchRequest()
	{
	JSONObject request=new JSONObject();
	request.put("FirstName", "firstCar1");
	
	 baseURI="http://localhost:3000/";
	 given().
	 contentType(ContentType.JSON).
	 accept(ContentType.JSON).
	 header("Content-Type", "application/json").
	 body(request.toJSONString()).
	 when().
	 patch("/users/4").
	 then().
	 statusCode(200).log().all();
	}
	
	@Test
	public void putRequest()
	{
	JSONObject request=new JSONObject();
	request.put("FirstName", "firstcar1");
	request.put("LastName", "secondCar1");
	request.put("SubjectID", 1);
	
	 baseURI="http://localhost:3000/";
	 given().
	 contentType(ContentType.JSON).
	 accept(ContentType.JSON).
	 header("Content-Type", "application/json").
	 body(request.toJSONString()).
	 when().
	 put("/users/4").
	 then().
	 statusCode(200).log().all();
	}
	
	//@Test
	public void putRequest01()
	{
	JSONObject request=new JSONObject();
	request.put("FirstName", "firstcar3");
	request.put("LastName", "secondCar3");
	request.put("SubjectID", 1);
	
	 baseURI="http://localhost:3000/";
	 given().
	 contentType(ContentType.JSON).
	 accept(ContentType.JSON).
	 header("Content-Type", "application/json").
	 body(request.toJSONString()).
	 when().
	 put("/users/4").
	 then().
	 statusCode(200).log().all();
	}
	
	//@Test
		public void putRequest03()
		{
		JSONObject request=new JSONObject();
		request.put("FirstName", "firstcar5");
		request.put("LastName", "secondCar5");
		request.put("SubjectID", 1);
		
		 baseURI="http://localhost:3000/";
		 given().
		 contentType(ContentType.JSON).
		 accept(ContentType.JSON).
		 header("Content-Type", "application/json").
		 body(request.toJSONString()).
		 when().
		 put("/users/").
		 then().
		 statusCode(200).log().all();
		}
	
	
		
}
