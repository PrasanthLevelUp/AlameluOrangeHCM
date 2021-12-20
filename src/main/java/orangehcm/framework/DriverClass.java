package orangehcm.framework;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverClass {
	
	public static WebDriver driver;
	public static String configfile="./src/main/resources/config.properties";
	public static Properties prop= null;
	
	@BeforeSuite
	public void setup() {
		prop=ProperityFile.loadPropertyFile(configfile);
	}
	
	public void laucnhdriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	
	public void teardown() {
		driver.quit();
	}

}
