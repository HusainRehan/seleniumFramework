package seleniumFramework.base;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import seleniumFramework.constants.Constants;
import seleniumFramework.util.ExcelUtil;
import seleniumFramework.util.PropertyUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseTest extends AbstractBase {
	private static final Logger logger = LogManager.getLogger(BaseTest.class);
	
	ThreadLocal<WebDriver> th = new ThreadLocal<WebDriver>();
	
	@BeforeSuite
	public void intialize() throws Exception {
		PropertyUtil.loadProperties();
		ExcelUtil.loadTestTestData();
	}
	
	@BeforeMethod
	public void setUp(ITestContext context, Method method) {
		Map<String, String> localParameters= context.getCurrentXmlTest().getLocalParameters();
		String browser = localParameters.get("browser");
		
		WebDriver driver;
		if (Constants.CHROME.equals(browser)) {
			driver = new ChromeDriver();
		}
		else if (Constants.FIREFOX.equals(browser)) {
			driver = new FirefoxDriver();
		}
		else if (Constants.EDGE.equals(browser)) {
			driver = new EdgeDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		logger.info("Browser insatnce created: " + browser);
		th.set(driver);
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
		
	}
	
	@AfterMethod
	public void tearDown() {
		if (getDriver() != null) {
			getDriver().quit();
		}		
	}
	protected WebDriver getDriver() {
		return th.get();
	}
	
	@DataProvider(name = "RowData")
	public Object[][] getRowData(Method method) {
		Map<String, String> TestCaseData = ExcelUtil.getTestCaseData(method.getName());
		Object[][] data = new Object[1][1];
		data[0][0] = TestCaseData;
		return data;

}
}
