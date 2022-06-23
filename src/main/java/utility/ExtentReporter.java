package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	static ExtentReports extentReport;
	public static ExtentReports getExtentReport() {
		
		String extentReportPath=System.getProperty("user.dir")+"\\Report\\extentReport";
		ExtentSparkReporter reporter=new ExtentSparkReporter(extentReportPath);	
		reporter.config().setReportName("Chankya uni");
		reporter.config().setDocumentTitle("Test result");
		extentReport= new ExtentReports();
		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo("Operrating System","window10");
		extentReport.setSystemInfo("Tested by","monal");
		
		
		
			
				
		
		return extentReport;
		
	}

}
