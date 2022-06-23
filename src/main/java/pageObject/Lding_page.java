package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Lding_page {
	WebDriver driver;
	
	public Lding_page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@title='My Account']")
	private WebElement myAccountDropdown;
	
	@FindBy(linkText="Login")
	private WebElement LoginOption;
	
	public WebElement myAccountDropdown()
	{
		return myAccountDropdown;
	}
	public WebElement LoginOption()
	{
		return LoginOption;
	}

}
