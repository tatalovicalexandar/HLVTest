package local.HLVTestApp.listeners;

import java.io.IOException;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;
import local.HLVTestApp.base.BaseTest;
import local.HLVTestApp.base.TestUtilities;

public class TestListener extends BaseTest implements ITestListener{

	public TestListener() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			test.log(Status.FAIL, "Failed Test Case is: " + result.getName());
			test.addScreenCaptureFromPath(TestUtilities.takeScreenshot(result.getName()));
			test.log(Status.FAIL, result.getName() + " FAIL with error " + result.getThrowable());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(NullPointerException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		report.flush();
	}

}
