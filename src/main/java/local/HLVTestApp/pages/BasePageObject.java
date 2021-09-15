package local.HLVTestApp.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import local.HLVTestApp.reports.ExtentReporting;

public class BasePageObject {

	protected WebDriver driver;
	
	public BasePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	/** Open page with given URL */
	protected void openUrl(String url) {
		driver.get(url);
	}
	
	/** Find element using given locator */
	protected WebElement find(By locator) {
		return driver.findElement(locator);
	}
	
	/** Click on element with given locator when it's visible */
	protected void click(By locator) {
		//waitForVisibilityOf(locator, 5);
		find(locator).click();
	}
	
	/** Type given text into element with given locator */
	protected void type(String text, By locator) {
		//waitForVisibilityOf(locator, 5);
		find(locator).sendKeys(text);
	}
	
	/** Get URL of current page from browser */
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	/** Wait for specific ExpectedCondition for the given amount of time in seconds*/
	private void waitFor(ExpectedCondition<WebElement> condition, Integer timeoutInSeconds) {
		timeoutInSeconds = timeoutInSeconds != null ? timeoutInSeconds : 30;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		wait.until(condition);
	}
	
	/** Wait for given number of seconds for element with given locator to be visible on the page */
	protected void waitForVisibilityOf(By locator, Integer... timeoutInSeconds) {
		int attempts = 0;
		while(attempts < 2) {
			try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator), (timeoutInSeconds.length > 0 ? timeoutInSeconds[0] : null));
				break;
			} catch (StaleElementReferenceException e) {
				
			}	
			attempts++;
		}
	}
}
