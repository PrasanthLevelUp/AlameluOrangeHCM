package orangehcm.framework;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverClass {

	public static WebDriver driver;
	public static String configfile = "./src/main/resources/config.properties";
	public static String extendreportpath = "./Reports";
	public static String testdatafile = "./src/main/resources/TestData.xlsx";
	public static Properties prop = null;
	public static ExtentReports extent = null;

	@BeforeSuite
	public void setup() {
		prop = ProperityFile.loadPropertyFile(configfile);
		extent = ExtendReportFile.extentReportconfig(extendreportpath);
		ExcelFileRead.readexcel(testdatafile, prop.getProperty("sheetname"));
	}

	public void laucnhdriver() {
		switch (prop.getProperty("broswer")) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			break;
		}

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
