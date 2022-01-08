package orangehcm.testcases;

import java.util.HashMap;

import org.apache.logging.log4j.Level;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import orangehcm.framework.DriverClass;
import orangehcm.framework.ExcelFileRead;
import orangehcm.pages.HomePage;
import orangehcm.pages.LoginPage;
import orangehcm.utils.SeleniumUtils;

public class TC1_ValidateLogin extends DriverClass {

	@Test
	public void logintest() {
		test = extent.createTest(new Object(){}.getClass().getEnclosingMethod().getName());
		HashMap<String,String> getdata = ExcelFileRead.getData(this.getClass().getSimpleName());
		try {
			laucnhdriver();
			logger.info("test");
			test.log(Status.PASS, "Driver Launched");
			LoginPage login = new LoginPage(driver);
			HomePage home = login.login(getdata.get("LoginUsername"), getdata.get("LoginPassword"));
			SeleniumUtils.textvalidation(home.loggedusername,getdata.get("LoggedUser"));
			test.log(Status.PASS, "Login Successfull");
			closebrowser();
		} catch (Exception e) {
			test.log(Status.FAIL, e.getMessage());
		}
	}
	
	@Test(enabled = false)
	public void logintest2() {
		test = extent.createTest(new Object(){}.getClass().getEnclosingMethod().getName());
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
