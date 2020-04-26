package com.bridgelabz.seliniumtesting.utility;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtendManager {

	   private static ExtentReports extent;
	
	    public synchronized static ExtentReports getReporter(String reportName) {
	    	System.out.println("reportname--->"+reportName);
	            String workingDir = System.getProperty("user.dir");
	                extent = new ExtentReports(workingDir + "\\ExtentReports\\"+ reportName+".html", true);
	        return extent;
	    }
}