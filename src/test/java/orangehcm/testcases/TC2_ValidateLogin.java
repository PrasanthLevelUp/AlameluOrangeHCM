package orangehcm.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import orangehcm.framework.DriverClass;
import orangehcm.pages.LoginPage;

public class TC2_ValidateLogin extends DriverClass {

	@Test
	public void logintest() {
		ExtentTest test = extent.createTest(new Object(){}.getClass().getEnclosingMethod().getName());
		try {
			laucnhdriver();
			test.log(Status.PASS, "Driver Launched");
			LoginPage login = new LoginPage(driver);
			login.login(prop.getProperty("username"), prop.getProperty("password"));
			test.log(Status.PASS, "login successfull");
			closebrowser();
		} catch (Exception e) {
			test.log(Status.FAIL, e.getMessage());
		}
	}
	
	@Test
	public void logintest2() {
		ExtentTest test = extent.createTest(new Object(){}.getClass().getEnclosingMethod().getName());
		try {
			laucnhdriver();
			test.log(Status.PASS, "Driver Launched");
			LoginPage login = new LoginPage(driver);
			login.login(prop.getProperty("username"), prop.getProperty("password"));
			test.log(Status.PASS, "login successfull");
			closebrowser();
		} catch (Exception e) {
			test.log(Status.FAIL, e.getMessage());
		}
	}

}
