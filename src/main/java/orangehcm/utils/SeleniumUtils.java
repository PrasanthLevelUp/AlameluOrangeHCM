package orangehcm.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import orangehcm.framework.DriverClass;

public class SeleniumUtils extends DriverClass {

	public static void entertext(WebElement ele, String value) {
		try {
			waitvisibleele(ele);
			ele.clear();
			ele.sendKeys(value);
			logpass("The Value Entered as: " + value);
		} catch (Exception e) {
			logfail(e.getMessage());
		}
	}

	public static void seleiumclick(WebElement ele) {
		try {
			waitclickable(ele);
			ele.click();
			logpass("Element was clicked");
		} catch (Exception e) {
			logfail(e.getMessage());
		}
	}
	
	public static void textvalidation(WebElement ele, String exptxt) {
		try {
			Assert.assertTrue(waitvisibletxt(ele,exptxt));
			logpass("Expected value is " +exptxt+" actual was matched "+ele.getText());
		} catch (Exception e) {
			logfail(e.getMessage());
		}
	}
	
	public static void logpass(String desc) {
		test.log(Status.PASS, desc+test.addScreenCaptureFromPath(getscreenshot()));
	}
	
	public static void logfail(String desc) {
		test.log(Status.FAIL, desc+test.addScreenCaptureFromPath(getscreenshot()));
	}
	
	
	public static String getscreenshot() {
		String filepath=null;
		try {
			TakesScreenshot screen = (TakesScreenshot) driver;
			File source = screen.getScreenshotAs(OutputType.FILE);
			
			filepath = screenshotspath +"/Screen_"+JavaUtils.randonnumber()+".png";
			File desination = new File(filepath);
			FileUtils.copyFile(source, desination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filepath;
	}

	public static void waitvisibleele(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static boolean waitvisibletxt(WebElement ele,String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		return wait.until(ExpectedConditions.textToBePresentInElement(ele, text));
	}

	public static void waitclickable(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

}
