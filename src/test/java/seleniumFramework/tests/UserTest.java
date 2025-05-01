package seleniumFramework.tests;

import java.util.Map;

import org.testng.annotations.Test;

import seleniumFramework.base.BaseTest;

public class UserTest extends BaseTest {
	
	@Test(dataProvider = "RowData")
		public void VerifyCreateUserTest(Map<String, String> testData) {
			System.out.println(testData);
		
	}
	
}
