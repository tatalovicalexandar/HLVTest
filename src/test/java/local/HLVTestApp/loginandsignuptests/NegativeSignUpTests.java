package local.HLVTestApp.loginandsignuptests;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import local.HLVTestApp.base.BaseTest;
import local.HLVTestApp.base.CsvDataProviders;
import local.HLVTestApp.pages.FinalSignUpPageObject;
import local.HLVTestApp.pages.ResponsiveSocialLoginFormPageObject;
import local.HLVTestApp.pages.SignUpPageObject;

public class NegativeSignUpTests extends BaseTest{
	
	@Test(dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class, description="User already exist")
	public void verifyUnsuccessfulSignUpAction(Map<String, String> testData) {
		
		// Data from data provider
		//String no = testData.get("no");
		String firstName = testData.get("firstName");
		String lastName = testData.get("lastName");
		String username = testData.get("username");
		String email = testData.get("email");
		String password = testData.get("password");
		String mobile = testData.get("mobile");
		String expectedSuccessfulMessage = testData.get("expectedSuccessfulMessage");
		String expectedUnsuccessfulMessage = testData.get("expectedUnsuccessfulMessage");
		
		// Include test in test report
		test = report.createTest("verifyUnsuccessfulSignUpAction");
		
		// Open main page
		ResponsiveSocialLoginFormPageObject mainPage = new ResponsiveSocialLoginFormPageObject(driver);
		mainPage.openPage();
		
		// Open Sign Up Form page	
		SignUpPageObject signUpForm = mainPage.clickOnSignUpButton();
		
		// Execute sign up
		FinalSignUpPageObject finalSignUpPage = signUpForm.signUp(firstName, lastName, username, email, password, mobile);
		
		// Verification: New URL
		Assert.assertEquals(finalSignUpPage.getPageUrl(), signUpForm.getCurrentUrl());

		// Verification: HOME Link is visible
		Assert.assertTrue(finalSignUpPage.isHomeLinkVisible(), "HOME link is visible.");
		
		// Unsuccessful sign up message
		String actualUnsuccessMessage = finalSignUpPage.getMessageText();
		Assert.assertEquals(expectedUnsuccessfulMessage, actualUnsuccessMessage);
	}
}
