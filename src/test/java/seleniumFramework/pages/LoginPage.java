package seleniumFramework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import seleniumFramework.base.BasePage;
import seleniumFramework.exception.VerificationFailedException;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(name = "username")
	public WebElement usernameTxnBtn;
	@FindBy(name = "password")
	public WebElement passwordTxnBtn;
	@FindBy(className = "orangehrm-login-button")
	public WebElement loginBtn;
	
	public void verifyLogin() {
	try {
		enterText(usernameTxnBtn, "Admin");
		enterText(passwordTxnBtn, "admin123");
		click(loginBtn);
	} catch (Exception e) {
		System.out.println("element not interactable: " + e.getMessage());
		throw new VerificationFailedException("element not interactable: " + e.getMessage());
	}
	}

}
