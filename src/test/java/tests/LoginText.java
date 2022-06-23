package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.AccountPage;
import pageObject.Lding_page;
import pageObject.LoginPage;
import resources.BaseClass1;

public class LoginText extends BaseClass1{
	Logger log;
	public WebDriver  driver;
	

	
	/*@Test
	public void login() throws IOException, InterruptedException {
		
	 driver =	intializeDriver();
	driver.get(prop.getProperty("url"));
	
	Lding_page landingPage=new Lding_page(driver);
	landingPage.myAccountDropdown().click();
	landingPage.LoginOption().click();
	Thread.sleep(3000);
	LoginPage lPage=new LoginPage(driver);
	lPage.emailAddressField().sendKeys(prop.getProperty("email"));
	lPage.passwordField().sendKeys(prop.getProperty("password"));
	lPage.LoginButton().click();
	
	AccountPage accPage=new AccountPage(driver);
	Assert.assertTrue(accPage.editinformation().isDisplayed());
	}
	
	@AfterMethod
public void closur() {
		driver.close();*/
	
	@Test(dataProvider="getloginData")
	public void login(String email,String password,String expectedStatus ) throws InterruptedException, IOException
	{
		 //log=LogManager.getLogger(LoginText.class.getName());
		
		
		Lding_page landingPage=new Lding_page(driver);
		landingPage.myAccountDropdown().click();
		log.debug("Clicked on my account dropdown");
		landingPage.LoginOption().click();
		log.debug("Clicked on login page");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		LoginPage lPage=new LoginPage(driver);
		lPage.emailAddressField().sendKeys(email);
		log.debug("Email address got entered");
		lPage.passwordField().sendKeys(password);
		log.debug("password  got entered");
		lPage.LoginButton().click();
		log.debug("clicked on login button");
		
		AccountPage accPage=new AccountPage(driver);
		String actualResult;
		String failureResult;
		try {
			accPage.editinformation().isDisplayed();
			actualResult="Sucessful";
			log.debug("user got login");
		}catch(Exception e) {
			actualResult="Failure";
			log.debug("user failed login");
		}
		Assert.assertEquals(actualResult, expectedStatus);
		log.info("Login test get passed");
	}
	@BeforeMethod
	public void openapplication() throws IOException {
		 log=LogManager.getLogger(LoginText.class.getName());
		driver =	intializeDriver();
		log.debug("Browser get launched");
		driver.get(prop.getProperty("url"));	
	}
		
		@AfterMethod
	public void closur() {
			driver.close();
			log.debug("browser get closed");
	
}
		@DataProvider
		public Object getloginData() {
			Object[][] data= {{"sonalkharde05@gmail.com","B@s98765432","Sucessful"},{"dummy@test.com","dummy","Failure"}};
			 return data;
			
		}
}
