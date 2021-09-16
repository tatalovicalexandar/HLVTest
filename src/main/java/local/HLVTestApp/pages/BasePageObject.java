package local.HLVTestApp.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePageObject {

	protected WebDriver driver;
	protected Logger log;
	
	public BasePageObject(WebDriver driver, Logger log) {
		this.driver = driver;
		this.log = log;
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
		find(locator).click();
	}
	
	/** Type given text into element with given locator */
	protected void type(String text, By locator) {
		find(locator).sendKeys(text);
	}
	
	/** Get URL of current page from browser */
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
}
