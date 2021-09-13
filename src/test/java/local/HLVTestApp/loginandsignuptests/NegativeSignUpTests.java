package local.HLVTestApp.loginandsignuptests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import local.HLVTestApp.base.BaseTest; // DO NOT REMOVE THIS IMPORT - This import is necessary in order to execute getCurrentTestNameFromXml() method from BaseTest class
import local.HLVTestApp.pages.FinalSignUpPageObject;
import local.HLVTestApp.pages.ResponsiveSocialLoginFormPageObject;
import local.HLVTestApp.pages.SignUpPageObject;

public class NegativeSignUpTests extends PositiveSignUpTests{
	
	@Parameters({ "firstName", "lastName", "username", "email", "password", "mobile", "expectedSuccessfullMessage", "expectedUnsuccessfullMessage" })
	@Test(description="User already exist", dependsOnMethods = { "verifySuccessfullSignUpAction" })
	public void verifyUnsuccessfullSignUpAction(String firstName, String lastName, String username, String email, String password, String mobile, String expectedSuccessfullMessage, String expectedUnsuccessfullMessage) {
		
		// Include test in test report
		test = report.createTest("verifyUnsuccessfullSignUpAction");
		
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
		String textName = super.getCurrentTestNameFromXml();
		String expectedMessage;
		if(textName == "verifySuccessfullSignUpAction")
			expectedMessage = expectedSuccessfullMessage;
		else
			expectedMessage = expectedUnsuccessfullMessage;
			
		String actualUnsuccessMessage = finalSignUpPage.getMessageText();
		Assert.assertEquals(expectedMessage, actualUnsuccessMessage);
	}
}
