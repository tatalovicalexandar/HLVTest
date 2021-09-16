package local.HLVTestApp.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinalSignUpPageObject  extends BasePageObject{
	
	private String pageUrl = "http://localhost:8080/addUser";
	
	private By formHomeLink = By.xpath("//a[@href='/']");
	private By message = By.xpath("//h3[1]");

	public FinalSignUpPageObject(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** Get URL variable from PageObject */
	public String getPageUrl() {
		return pageUrl;
	}
	
	/** Check if expected HOME link is visible */
	public boolean isHomeLinkVisible() {
		return find(formHomeLink).isDisplayed();
	}
	
	/** Return text from message */
	public String getMessageText() {
		return find(message).getText();
	}
}
