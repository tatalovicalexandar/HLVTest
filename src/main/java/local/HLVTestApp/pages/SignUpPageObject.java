package local.HLVTestApp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPageObject extends BasePageObject{

	private String pageUrl = "http://localhost:8080/signup";
	
	private By formFirstNameTextBoxLocator = By.name("user_fname");
	private By formLastNameTextBoxLocator = By.xpath("//div[@class='container']/input[2]");
	private By formUsernameTextBoxLocator = By.name("username");
	private By formEmailTextBoxLocator = By.name("user_email");
	private By formPasswordTextBoxLocator = By.name("user_pass");
	private By formMobileTextBoxLocator = By.name("user_mobile");
	//private By formCancelButtonLocator = By.xpath("//button[@class='cancelbtn']");
	private By formSignUpButtonLocator = By.xpath("//button[@class='signupbtn']");
	private By formHomeLink = By.xpath("//a[@href='/']");
	private By successfullMessage = By.xpath("//h3[@value=' User has been successfully registered.']");//" User has been successfully registered."
	private By unsuccessfullMessage = By.xpath("//h3[@value=' Oops!  There is already a user registered with the email provided.']"); //" Oops!  There is already a user registered with the email provided."
	
	
	public SignUpPageObject(WebDriver driver) {
		super(driver);
	}
	
	/** Execute sign up */
	public FinalSignUpPageObject signUp(String firstName, String lastName, String username, String email, String password, String mobile) {
		type(firstName, formFirstNameTextBoxLocator);
		type(lastName, formLastNameTextBoxLocator);
		type(username, formUsernameTextBoxLocator);
		type(email, formEmailTextBoxLocator);
		type(password, formPasswordTextBoxLocator);
		type(mobile, formMobileTextBoxLocator);
		click(formSignUpButtonLocator);
		return new FinalSignUpPageObject(driver);
	}
	
	/** Get URL variable from PageObject */
	public String getPageUrl() {
		return pageUrl;
	}
	
	/** Check if expected HOME link is visible */
	public boolean isHomeLinkVisible() {
		return find(formHomeLink).isDisplayed();
	}
	
	/** Return text from success message */
	public String getSuccessMessageText() {
		return find(successfullMessage).getText();
	}
	
	/** Return text from success message */
	public String getUnsuccessMessageText() {
		return find(unsuccessfullMessage).getText();
	}

}
