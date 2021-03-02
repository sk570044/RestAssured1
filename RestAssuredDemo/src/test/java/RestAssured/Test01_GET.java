package RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import  io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Test01_GET {
	
	@Test
	void test()
	{
	   Response response= get("https://reqres.in/api/users?page=2");
	   System.out.println(response.getStatusCode());
	   System.out.println(response.getBody());
	   System.out.println(response.getTime());
	   System.out.println(response.getHeaders());
	   
	   int statusCode=response.getStatusCode();
	   Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	void Test01()
	{
	  given()
	  .get("https://reqres.in/api/users?page=2")
	  .then()
	  .statusCode(200)
	  .body("data.id[0]", equalTo(7));
		
		
	}

}
