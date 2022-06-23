package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.BaseClass1;

public class TestTwo extends BaseClass1 {
	public WebDriver  driver;
	@Test
	public void testTwo() throws IOException, InterruptedException {
		System.out.println("This is test two");
 driver =	intializeDriver();
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		driver.close();
	}

}
