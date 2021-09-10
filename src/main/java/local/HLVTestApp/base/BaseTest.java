package local.HLVTestApp.base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class BaseTest {

	protected WebDriver driver;
	protected String testName;
	
	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun=true)
	public void setUp(@Optional("chrome") String browser, ITestContext ctx){
		String testName = ctx.getCurrentXmlTest().getName();
		this.testName = testName;
		
		BrowserDriverFactory factory = new BrowserDriverFactory(browser);
		driver = factory.createDriver();
		driver.manage().window().maximize();
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		// Close browser
		driver.quit();
	}
	
	public String getCurrentTestNameFromXml() {
		return this.testName;
	}

}
