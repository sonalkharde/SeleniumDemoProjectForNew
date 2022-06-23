package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.BaseClass1;

public class testFour extends BaseClass1  {
	public WebDriver  driver;
	@Test
	public void testfour() throws IOException, InterruptedException {
		
			System.out.println("This is test two");
		  driver =	intializeDriver();
			driver.get("https://www.flipkart.com/");
			Thread.sleep(2000);
			Assert.assertTrue(false);
			driver.close();
		}
@AfterMethod
public void ClossingBrowser() {
	driver.close();
}



}
