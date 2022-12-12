package neoStoxUtilityClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class NeoStoxUtility 
{
	public static String readdatafromproperties(String key) throws IOException
	{
		Properties prp= new Properties();
		
		FileInputStream myfile= new FileInputStream("C:\\Users\\lenovo\\eclipse-workspace\\Investment_Banking1\\neoStoxProp.properties");
		
		prp.load(myfile);
		
		String value = prp.getProperty(key);
		
		return value;
	}
	
	public static void screenshot(WebDriver driver, String TCID) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dist = new File("E:\\Testing Class\\Automation Testing\\Selenium\\Selenium Screenshot\\"+TCID+".png");
	
		FileHandler.copy(src, dist);
	}
	
	public static void Wait(WebDriver driver, int waitTime)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
		
	}
}
