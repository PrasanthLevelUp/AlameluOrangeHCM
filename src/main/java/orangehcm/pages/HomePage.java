package orangehcm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver mydriver;

	public HomePage(WebDriver driver) {
		this.mydriver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[@id='welcome']")
	public WebElement loggedusername;
	
	

}
