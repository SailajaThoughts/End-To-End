package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNg {

	ExtentReports er;
	public ExtentReports getReportObject() {
		
String path=System.getProperty("user.dir")+"\\reports\\index.html";
		
		//ExtentReports, ExtentSparkReporter
		ExtentSparkReporter esr=new ExtentSparkReporter(path);
		esr.config().setReportName("WebAutomation Results");
		
		//document title
		esr.config().setDocumentTitle("Test REsults");
		
		er=new ExtentReports();
		//ExtentSparkReports is configuration class and it 
		//reports to its main class
		er.attachReporter(esr);
		er.setSystemInfo("Tester", "cool");
		return er;
	}
}
