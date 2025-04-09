package ExtentReportPack;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class MyReport 
{   
	
	public static ExtentReports getExtentReport()
	{
		 ExtentReports reports = new ExtentReports();
		 
		 ExtentSparkReporter ExtentSparkReporter = new ExtentSparkReporter("./ExtentReportFolder/ExtentSpark.html");
		 
		 reports.attachReporter(ExtentSparkReporter);
		 
		 return reports;
		 
		 
	}
	
}
