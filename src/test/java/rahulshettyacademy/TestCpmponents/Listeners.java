package rahulshettyacademy.TestCpmponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import rahulshettyacademy.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener {
	
	ExtentTest test;

	ExtentReports extent = ExtentReporterNG.getReportObject();
	//test,test
	ThreadLocal <ExtentTest> extentTest = new ThreadLocal();//Thread safe
	
	@Override
	public void onTestStart(ITestResult result) {
	    System.out.println("onTestStart" + result.getMethod().getMethodName());
		test =extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);//unique thread id(ErrorValidationTest()->test
	  }

	 
	@Override  
	public void onTestSuccess(ITestResult result) {
	    System.out.println("onTestSuccess"+result.getMethod().getMethodName());

	    extentTest.get().log(Status.PASS, "Test Passed");
	    
	  }

	@Override
	   public void onTestFailure(ITestResult result) {
	    System.out.println("onTestFailure"+result.getMethod().getMethodName());

		
	    extentTest.get().fail(result.getThrowable());
		  
		  try { 
			  driver = (WebDriver)
		  result.getTestClass().getRealClass().getField("driver").get(result.getInstance()); 
		  } 
		  catch (Exception e1) { // TODO Auto-generated catch block
		  e1.printStackTrace(); 
		  } 
		  String filePath = null; 
		  try { 
			  String filepath = getScreenshot(result.getMethod().getMethodName() , driver);
			
			  } 
		  
		  catch(IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
			  extentTest.get().addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
		  }
		 
	    //Screenshot, Attach the report
	  }

	@Override  
	   public void onTestSkipped(ITestResult result) {
	    System.out.println("onTestSkipped"+result.getMethod().getMethodName());
	    extentTest.get().log(Status.SKIP, result.getMethod().getMethodName());
	  }

	@Override
	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    System.out.println("onTestFailedButWithinSuccessPercentage"+result.getMethod().getMethodName());

	  }

	  
	@Override 
	  public void onTestFailedWithTimeout(ITestResult result) {
	    System.out.println("onTestFailedWithTimeout"+result.getMethod().getMethodName());

		onTestFailure(result);
	  }

	@Override 
	  public  void onStart(ITestContext context) {
	    System.out.println("onStart");
 
	  }

	@Override
	  public void onFinish(ITestContext context) {
	    System.out.println("onFinish");

		extent.flush();
	  }
}
