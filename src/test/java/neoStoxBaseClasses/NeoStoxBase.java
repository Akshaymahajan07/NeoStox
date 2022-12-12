package neoStoxBaseClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import neoStoxPOMclasses.NeoStoxUtility;

public class NeoStoxBase 
{
	protected static WebDriver driver;
	
	public void BrowserLaunch() throws IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Testing Class\\Automation Testing\\Selenium\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		

		Thread.sleep(1000);

		
		driver.get(NeoStoxUtility.readdatafromproperties("url"));
		
	}
	

}
