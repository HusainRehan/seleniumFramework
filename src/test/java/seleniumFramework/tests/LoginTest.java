package seleniumFramework.tests;

import org.testng.annotations.Test;

import seleniumFramework.base.BaseTest;
import seleniumFramework.pages.LoginPage;

public class LoginTest extends BaseTest {
	@Test
	public void Logintest() {
		LoginPage loginPage = new LoginPage(getDriver());
	getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		loginPage.verifyLogin();
		System.out.println("Login test completed successfully");
		
	}

}
