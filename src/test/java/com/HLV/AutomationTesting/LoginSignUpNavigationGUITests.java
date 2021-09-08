package com.HLV.AutomationTesting;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class LoginSignUpNavigationGUITests {

	//private final static String chromeWebDriverLocation = "C:\\Users\\Aleksandar-PC\\chromedriver_win32\\chromedriver.exe";
	private final static String chromeWebDriverLocation = "C:\\Users\\atatalovic\\chromedriver_win32\\chromedriver.exe";
	static WebDriver driver;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver",chromeWebDriverLocation);
		driver = new ChromeDriver();
		//driver.get("http://localhost:8080/");
		//driver.manage().window().maximize();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		driver.quit();
	}
	
	@BeforeEach
	private void tearDownBeforeEach() throws Exception {
		driver.get("http://localhost:8080/");
		driver.manage().window().maximize();
	}
	
	@AfterEach
	private void tearDownAfterEach() throws Exception {
		//driver.close();
	}

	@Test
	void verifyNavigationMainPageToLoginForm() {
		WebElement login = driver.findElement(By.cssSelector("a[href = 'login']"));
		login.click();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "http://localhost:8080/login";
		
		Assert.assertEquals(expectedUrl, actualUrl);
	}
	
	@Test
	void verifyNavigationMainPageToSignupForm() {
		WebElement login = driver.findElement(By.cssSelector("a[href = 'signup']"));
		login.click();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "http://localhost:8080/signup";
		
		Assert.assertEquals(expectedUrl, actualUrl);
	}
	
	@Test
	void verifySuccessfullLoginActionOnMainPage() {
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.cssSelector("input[value = 'Login']"));
		
		username.sendKeys("Tatalovic");
		password.sendKeys("test1234");
		login.click();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "http://localhost:8080/login";
		
        Assert.assertEquals(expectedUrl, actualUrl);
	}
	
	@Test
	void verifySuccessfullLoginActionOnLoginPage() {
		driver.get("http://localhost:8080/login");
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.xpath("//button[@type = 'submit']"));
		
		username.sendKeys("Tatalovic");
		password.sendKeys("test1234");
		login.click();
		String actualTitle = driver.getTitle();
		String expectedTitle = "Insert title here";
		
        Assert.assertEquals(expectedTitle, actualTitle);
	}

}
