package seleniumFramework.tests;

import org.testng.annotations.Test;

import seleniumFramework.base.BaseTest;
import seleniumFramework.pages.LoginPage;
import seleniumFramework.util.PropertyUtil;

public class LoginTest extends BaseTest {
	@Test
	public void Logintest() {
		LoginPage loginPage = new LoginPage(getDriver());
	getDriver().get(getProperty("application.url"));
		loginPage.verifyLogin();
		System.out.println("Login test completed successfully");
		
	}
	@Test
	public void Logintest1() {
		LoginPage loginPage = new LoginPage(getDriver());
	getDriver().get(getProperty("application.url"));
		loginPage.verifyLogin();
		System.out.println("Login test completed successfully");
		
	}

}
