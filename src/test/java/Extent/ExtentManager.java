package Extent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	    public static final ExtentReports extentReports = new ExtentReports();
	    public synchronized static ExtentReports createExtentReports() {
	        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/Orange_HRM_extent-report.html");
	        reporter.config().setReportName("Orange_HRM_Test Report");
	        extentReports.attachReporter(reporter);
	        extentReports.setSystemInfo("Company", "ThoughtCoders");
	        extentReports.setSystemInfo("Author", "Ajeet");
	        return extentReports;
	    }
		
	
}