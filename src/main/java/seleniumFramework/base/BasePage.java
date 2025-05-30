package seleniumFramework.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import seleniumFramework.exception.WebElementException;
import seleniumFramework.util.ExcelUtil;

public class BasePage extends AbstractBase {
	private static final Logger logger = LogManager.getLogger(ExcelUtil.class);
	
	private WebDriver driver;
	private WebDriverWait explicitWait;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	protected WebDriver getDriver() {
		return driver;
	}
	
	protected void enterText(WebElement element, String text) {
		try {
			explicitWait.until(ExpectedConditions.visibilityOf(element));
			element.clear();
			element.sendKeys(text);
		} catch (Exception e) {
			logger.error("element not interactable: " + element.toString());
			logger.error("element not interactable: " + e.getMessage());
			throw new WebElementException("element not interactable: " + e.getMessage());
		}
		
	}
	
	
	
	
	protected void enterText(By by, String text) {
		try {
			WebElement element = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(by));
			element.clear();
			element.sendKeys(text);
		} catch (Exception e) {
			System.out.println("element not interactable: " + by.toString());
			System.out.println("element not interactable: " + e.getMessage());
			throw new WebElementException("element not interactable: " + e.getMessage());
		}
		
	}
	
	
	protected void click(WebElement element) {
		try {
			explicitWait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		} catch (Exception e) {
			System.out.println("element not interactable: " + element.toString());
			System.out.println("element not interactable: " + e.getMessage());
			throw new WebElementException("element not interactable: " + e.getMessage());
		}
		
	}
	
	protected void click(By by) {
		try {
			WebElement element = explicitWait.until(ExpectedConditions.elementToBeClickable(by));
			element.click();
		} catch (Exception e) {
			System.out.println("element not interactable: " + by.toString());
			System.out.println("element not interactable: " + e.getMessage());
			throw new WebElementException("element not interactable: " + e.getMessage());
		}
		
	}

}
