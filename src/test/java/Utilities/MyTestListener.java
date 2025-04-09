package Utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ExtentReportPack.MyReport;


public class MyTestListener extends NormalUtilities implements ITestListener
{
	ExtentReports report = MyReport.getExtentReport();
	ExtentTest test;
	

	@Override
	public void onTestStart(ITestResult result) {
		String testname = result.getName();
         test = report.createTest(testname);
		
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		String testname = result.getName();
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		String testname = result.getName();
		//test.log(Status.FAIL, testname+ "test failed");
		
	
	
			WebDriver driver = null;
		
				try {
					driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchFieldException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
				try {
					String temp = takeScreenShot(driver);
					test.addScreenCaptureFromPath(temp);
					System.out.println("Hi");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
