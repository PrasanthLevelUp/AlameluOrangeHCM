package orangehcm.framework;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import orangehcm.utils.JavaUtils;

public class ExtendReportFile {
	
	public static ExtentReports extentReportconfig(String filepath) {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(filepath+"/ExtendReport"+JavaUtils.randonnumber()+".html");
		extent.attachReporter(spark);
		return extent;
	}

}
