package orangehcm.framework;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverClass {
	
	public static WebDriver driver;
	public static String configfile="./src/main/resources/config.properties";
	public static String extendreportpath = "./Reports";
	public static Properties prop= null;
	public static ExtentReports extent=null;
	
	@BeforeSuite
	public void setup() {
		prop=ProperityFile.loadPropertyFile(configfile);
		extent = ExtendReportFile.extentReportconfig(extendreportpath);
	}
	
	public void laucnhdriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	
	public void closebrowser() {
		driver.close();
	}
	
	
	@AfterSuite
	public void teardown() {
		driver.quit();
		extent.flush();
	}

}
