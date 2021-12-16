package orangehcm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver mydriver;

	public LoginPage(WebDriver driver) {
		this.mydriver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@id='txtUsername']")
	WebElement usernametxtbox;
	@FindBy(xpath="//input[@id='txtPassword']")
	WebElement passwordtxtbox;
	@FindBy(xpath="//input[@id='btnLogin']")
	WebElement loginbtn;
	
	public HomePage login(String username,String password) {
		usernametxtbox.sendKeys(username);
		passwordtxtbox.sendKeys(password);
		loginbtn.click();
		return new HomePage(mydriver);
	}
	
	
}
