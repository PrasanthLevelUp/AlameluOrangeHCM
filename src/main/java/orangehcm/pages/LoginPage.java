package orangehcm.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import orangehcm.utils.SeleniumUtils;

public class LoginPage {
	
	WebDriver mydriver;

	public LoginPage(WebDriver driver) {
		this.mydriver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//page factory
	@FindBy(xpath="//input[@id='txtUsername']")
	WebElement usernametxtbox;
	@FindBy(xpath="//input[@id='txtPassword']")
	WebElement passwordtxtbox;
	@FindBy(xpath="//input[@id='btnLogin']")
	WebElement loginbtn;
	@FindBys(@FindBy(xpath="//table[@id='resultTable']//tbody//child::tr"))
	List<WebElement> results;
	
	public HomePage login(String username,String password) {
		SeleniumUtils.entertext(usernametxtbox, username);
		SeleniumUtils.entertext(passwordtxtbox, password);
		SeleniumUtils.seleiumclick(loginbtn);
		return new HomePage(mydriver);
	}
	
	
}
