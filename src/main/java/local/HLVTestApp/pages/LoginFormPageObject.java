package local.HLVTestApp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPageObject extends BasePageObject{
	
	private String pageUrl = "http://localhost:8080/login";
	
	private By formUsernameTextBoxLocator = By.name("username");
	private By formPasswordTextBoxLocator = By.name("password");
	private By formLogInButtonLocator = By.xpath("//button[@type='submit']");
	private By formHomeLink = By.xpath("//a[@href='/']");
	private By formReturnToLoginLink = By.xpath("//a[@href='/login/']");
	private By message = By.xpath("//h3[1]");
	
	public LoginFormPageObject(WebDriver driver) {
		super(driver);
	}

	/** Execute log in */
	public void logIn(String username, String password) {
		type(username, formUsernameTextBoxLocator);
		type(password, formPasswordTextBoxLocator);
		click(formLogInButtonLocator);
	}
	
	/** Get URL variable from PageObject */
	public String getPageUrl() {
		return pageUrl;
	}
	
	/** Check if expected HOME link is visible */
	public boolean isHomeLinkVisible() {
		return find(formHomeLink).isDisplayed();
	}
	
	/** Check if expected 'Return to Login For' link is visible */
	public boolean isReturnToLoginLinkVisible() {
		return find(formReturnToLoginLink).isDisplayed();
	}
	
	/** Return text from message */
	public String getMessageText() {
		return find(message).getText();
	}
}
