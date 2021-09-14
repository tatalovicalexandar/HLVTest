package local.HLVTestApp.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.reporters.Files;

public class TestUtilities extends BaseTest {

	public TestUtilities(WebDriver driver) {
		super();
		// TODO Auto-generated constructor stub
	}

	public static String takeScreenshot(String screenshotName) throws IOException{

		// Create a string variable which will be unique
		String dateFormat = new SimpleDateFormat("yyyyMMddhhss").format(new Date());
		
		// Create object variable of takeScreenshot class
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		
		// Create file which contain the screenshot reference
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		
		// Capture the screenshot in path variable
		String path = System.getProperty("user.dir") + "/test-output/screenshots/" + screenshotName + dateFormat + ".png";
		
		// New file object which contain destination path
		File destination = new File(path);
		
		// Save screenshot to desired location
		Files.copyFile(new FileInputStream(source), destination);

		return path;
	}

}
