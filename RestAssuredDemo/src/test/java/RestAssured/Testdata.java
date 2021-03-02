package RestAssured;

import org.testng.annotations.DataProvider;

public class Testdata {

//	@DataProvider(name = "DataForTest")
//	public Object[][] dataForTest()	{
//						
//		return new Object[][]{
//			{"Akhilesh", "Singh", 4 },
//			{"Jhamman", "Singh", 4 }
//			
//		 };
//	}
//	
	
	@DataProvider(name = "DataforDelete")
	public Object[] DataforDelete()	{
						
		return new Object[]{
			15,16,17,18,19,20
			
		 };
	}
}
