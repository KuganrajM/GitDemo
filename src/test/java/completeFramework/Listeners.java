package completeFramework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Extend_Report;
import resources.base;

public class Listeners extends base implements ITestListener {
	ExtentReports extent = Extend_Report.config();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	ExtentTest test;

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		extent.flush();

	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		//test.fail(arg0.getThrowable());
		extentTest.get().fail(arg0.getThrowable());
		WebDriver kugan = null;
		String testcaseName = arg0.getMethod().getMethodName();
		try {
			kugan = (WebDriver) arg0.getTestClass().getRealClass()
					.getDeclaredField("kugan").get(arg0.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException
				| NoSuchFieldException | SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			extentTest.get().addScreenCaptureFromPath(screenshot(testcaseName, kugan), arg0.getMethod().getMethodName());
			//screenshot(testcaseName, kugan);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		test = extent.createTest(arg0.getMethod().getMethodName());
		extentTest.set(test);

	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		//test.log(Status.PASS, "Test Passed");
		extentTest.get().log(Status.PASS, "Test Passed");

	}

}
