package neoStoxPOMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeoStoxPopup 
{
	@FindBy(xpath="(//a[text()='OK'])[2]")private WebElement okbutton;
	
	@FindBy(xpath = "(//a[text()='Close'])[5]")private WebElement close;

	
	//Create Constructor For popup
	public NeoStoxPopup(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Create Method for OK button
	public void okbutton() throws InterruptedException
	{
		okbutton.click();
		Reporter.log("Clicking on OK button", true);
		Thread.sleep(2000);
	}
	
	//create method fro cloase button 
	public void closebutton()
	{
		
		close.click();
		Reporter.log("Clickinh on Close button", true);
	}
}
