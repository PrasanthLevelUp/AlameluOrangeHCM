package orangehcm.utils;

import java.time.Duration;

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
			test.log(Status.PASS, "The Value Entered as: " + value);
		} catch (Exception e) {
			test.log(Status.FAIL, e.getMessage());
		}
	}

	public static void seleiumclick(WebElement ele) {
		try {
			waitclickable(ele);
			ele.click();
			test.log(Status.PASS, "Element was clicked");
		} catch (Exception e) {
			test.log(Status.FAIL, e.getMessage());
		}
	}
	
	public static void textvalidation(WebElement ele, String exptxt) {
		try {
			Assert.assertTrue(waitvisibletxt(ele,exptxt));
			test.log(Status.PASS, "Expected text is " + exptxt + " equal to Acutal text: "+ele.getText());
		} catch (Exception e) {
			test.log(Status.FAIL, e.getMessage());
		}
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
