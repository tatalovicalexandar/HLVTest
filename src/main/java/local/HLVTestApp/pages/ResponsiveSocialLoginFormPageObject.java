package local.HLVTestApp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResponsiveSocialLoginFormPageObject extends BasePageObject{

	public ResponsiveSocialLoginFormPageObject(WebDriver driver) {
		super(driver);
	}
	
	private String pageUrl = "http://localhost:8080/";
	
	private By formLoginButtonLocator = By.cssSelector("input[value = 'Login']");
	private By formLogInButtonLocator = By.cssSelector("a[href = 'login']");
	private By formSignUpButtonLocator = By.cssSelector("a[href = 'signup']");
	private By formLoginWithFacebookButtonLocator = By.xpath("//a[@class='fb btn']");
	private By formLoginWithTwitterButtonLocator = By.xpath("//a[@class='twitter btn']");
	private By formLoginWithGooglePlusButtonLocator = By.xpath("//a[@class='google btn']");
	private By formUsernameTextBoxLocator = By.name("username");
	private By formPasswordTextBoxLocator = By.name("password");

	/** Open Responsive Social Login Form Page with it's url */
	public void openPage() {
		openUrl(pageUrl);
	}
	
	/** Click on Login Button to authenticate user on Responsive Social Login Form Page */
	public void clickOnLoginButton() {
		click(formLoginButtonLocator);
	}
	
	/** Click on Login Button to authenticate user on Responsive Social Login Form Page */
	public void clickOnLoginWithFacebookButton() {
		click(formLoginWithFacebookButtonLocator);
	}
	
	/** Click on Login Button to authenticate user on Responsive Social Login Form Page */
	public void clickOnLoginWithTwitterButton() {
		click(formLoginWithTwitterButtonLocator);
	}
	
	/** Click on Login Button to authenticate user on Responsive Social Login Form Page */
	public void clickOnLoginWithGooglePlusButton() {
		click(formLoginWithGooglePlusButtonLocator);
	}
	
	/** Open LoginPage by clicking on Log In Button */
	public LoginFormPageObject clickOnLogInButton() {
		click(formLogInButtonLocator);
		return new LoginFormPageObject(driver);
	}
	
	/** Open SignUpPage by clicking on Sign Up Button */
	public SignUpPageObject clickOnSignUpButton() {
		click(formSignUpButtonLocator);
		return new SignUpPageObject(driver);
	}

	/** Execute log in on Responsive Social Login Form Page */
	public void logIn(String username, String password) {
		type(username, formUsernameTextBoxLocator);
		type(password, formPasswordTextBoxLocator);
		click(formLoginButtonLocator);
	}
	
	/** Get URL variable from PageObject */
	public String getPageUrl() {
		return pageUrl;
	}
}
