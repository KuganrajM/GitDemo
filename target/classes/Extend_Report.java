package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extend_Report {
	static ExtentReports extent;
	
	public static  ExtentReports config(){
		String path = System.getProperty("User.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Test Result");
		reporter.config().setDocumentTitle("Eend to End");
		
		 extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Kugan");
		return extent;
	
}
}
