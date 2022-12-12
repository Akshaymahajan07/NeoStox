package neoStoxPOMclasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeostoxMainPage 
{
	@FindBy(xpath = "(//span[@class='righttopmenu1'])[1]")private WebElement username;
	
	@FindBy(xpath = "(//span[@class='righttopmenu1'])[2]")private WebElement acbalance;
	
	@FindBy(id = "closepositions")private WebElement closepostiontab;

	
	
	//Create Constructor for MainPage
	public NeostoxMainPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Create Method For Username
	public String getusername()
	{
		String actualusername = username.getText();
		
		Reporter.log("Actual Username is "+actualusername);
		Reporter.log("Username of Account holder is "+actualusername, true);
		return actualusername;
		
		
		
		
	}
	
	//Create method for acbalance
	public void acbalance() throws IOException
	{
		 String accountbalance = acbalance.getText();
		 
		 Reporter.log("Getting account Balance", true);

		 
		 Reporter.log("Available Balance in account is "+accountbalance, true);
		
		
	}
	
	//Create Method for ClosePostion
	public void closepostiontab()
	{
		closepostiontab.click();
	}
	
	
	
	
}
