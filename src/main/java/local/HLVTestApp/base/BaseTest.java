package local.HLVTestApp.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;


public class BaseTest {

	protected WebDriver driver;
	
	@BeforeMethod(alwaysRun=true)
	public void setUp(@Optional("chrome") String browser){
		BrowserDriverFactory factory = new BrowserDriverFactory(browser);
		driver = factory.createDriver();
		driver.manage().window().maximize();
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		// Close browser
		driver.quit();
	}

}
