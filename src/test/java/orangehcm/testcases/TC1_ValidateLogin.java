package orangehcm.testcases;

import org.testng.annotations.Test;

import orangehcm.framework.DriverClass;
import orangehcm.pages.LoginPage;

public class TC1_ValidateLogin extends DriverClass{
	
	@Test
	public void logintest() {
		laucnhdriver();
		LoginPage login = new LoginPage(driver);
		login.login(prop.getProperty("username"), prop.getProperty("password"));
		teardown();
	}

}
