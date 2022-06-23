package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass1 {
	public Properties prop;
	public WebDriver driver;
	public WebDriver intializeDriver() throws IOException {
		
		 prop=new Properties();
		String propPath=System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";
		FileInputStream fis =new FileInputStream(propPath);
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
			
		}else if(browserName.equalsIgnoreCase("IE"))
		{
			 driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
		
	
			
		
	}
	
public String takesScreenshot(String testName , WebDriver driver) throws IOException {
	    File s= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    String d= System.getProperty("user.dir")+"\\Screenshot\\"+testName+".png";
	    		
	    FileUtils.copyFile(s, new File(d));
	    return d;
	    		
}
}
