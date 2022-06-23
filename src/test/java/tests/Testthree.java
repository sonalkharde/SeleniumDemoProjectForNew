package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.BaseClass1;

public class Testthree extends BaseClass1 {
	public WebDriver  driver;
	@Test
	public void testthree() throws IOException, InterruptedException {
		System.out.println("This is test two");
		WebDriver  driver =	intializeDriver();
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
		driver.close();
	}


}
