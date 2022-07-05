package TestingAcademy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNg;
import resources.base;


public class Listeners extends base implements ITestListener {

	ExtentReporterNg erN=new ExtentReporterNg();
	ExtentReports er=erN.getReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		
		test=er.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
	//SS when test fails
		//getThrowable gets all the failure logs
		//Here after test fails it comes innto this method.
		//So we are deliberate telling the test to fail and give the log
		extentTest.get().fail(result.getThrowable());
		//test.fail(result.getThrowable());
		WebDriver driver=null;
		String failedTest=result.getMethod().getMethodName();
		//System.out.println(failedTest);
		//first access test class, instance of that class
		//get field name, get Instance of that driver
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
		}

		try {	
				extentTest.get().addScreenCaptureFromPath(getScreenShotPath(failedTest,driver), result.getMethod().getMethodName());
				
				
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		
		er.flush();
	}



}
