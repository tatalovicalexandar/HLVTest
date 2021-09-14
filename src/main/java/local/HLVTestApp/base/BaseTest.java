package local.HLVTestApp.base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import local.HLVTestApp.reports.ExtentReporting;


public class BaseTest {

	protected static WebDriver driver;
	protected String testName;
	
	//get the reference of ExtentReports object to instantiate HTML reporting
    public static ExtentReports report = ExtentReporting.getExtentReportInstance();
    
    //indicate which test to include in report
    public static ExtentTest test;
	
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
