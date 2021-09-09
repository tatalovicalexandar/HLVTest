package local.HLVTestApp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPageObject extends BasePageObject{

	private String pageUrl = "http://localhost:8080/signup";
	
	private By formFirstNameTextBoxLocator = By.linkText("Form Authentication");
	private By formLastNameTextBoxLocator = By.linkText("Form Authentication");
	private By formUsernameTextBoxLocator = By.linkText("Form Authentication");
	private By formEmailTextBoxLocator = By.linkText("Form Authentication");
	private By formPasswordTextBoxLocator = By.linkText("Form Authentication");
	private By formMobileTextBoxLocator = By.linkText("Form Authentication");
	private By formCancelButtonLocator = By.linkText("Form Authentication");
	private By formSignUpButtonLocator = By.linkText("Form Authentication");
	
	
	public SignUpPageObject(WebDriver driver) {
		super(driver);
	}

}
