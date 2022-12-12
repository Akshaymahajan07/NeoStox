package neoStoxTestClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import neoStoxBaseClasses.NeoStoxBase;
import neoStoxPOMclasses.NeoStoxHomePage;
import neoStoxPOMclasses.NeoStoxLogin;
import neoStoxPOMclasses.NeoStoxLogout;
import neoStoxPOMclasses.NeoStoxPopup;
import neoStoxPOMclasses.NeoStoxUtility;
import neoStoxPOMclasses.NeostoxMainPage;

public class ValidateUsernameAndBalance extends NeoStoxBase
{
	NeoStoxHomePage mainpage;
	NeoStoxLogin login;
	NeostoxMainPage home;
	NeoStoxPopup welcome;
	NeoStoxLogout logout;
	
	@BeforeTest
	public void openBrowser() throws IOException, InterruptedException
	{
		BrowserLaunch();
		Reporter.log("Launching Browser...", true);
		mainpage = new NeoStoxHomePage(driver);
		login = new NeoStoxLogin(driver);
		home = new NeostoxMainPage(driver);
		welcome = new NeoStoxPopup(driver);
		logout = new NeoStoxLogout(driver);
	}
	
	@BeforeClass
	public void login() throws IOException, InterruptedException
	{
		mainpage.signin();
		Thread.sleep(1000);
		login.number(NeoStoxUtility.readdatafromproperties("userID"));
		Reporter.log("Entering username...",true);
		NeoStoxUtility.Wait(driver, 2000);
		login.signinbutton();
	
		NeoStoxUtility.Wait(driver, 2000);
		login.enterpin(NeoStoxUtility.readdatafromproperties("password"));
		
		Thread.sleep(2000);
		login.submitbutton();
		
		NeoStoxUtility.Wait(driver, 1000);
		Reporter.log("Logging in....", true);
		welcome.okbutton();
		
		welcome.closebutton();
		Thread.sleep(100);
		
	}

  @Test
  public void validatebalance() throws IOException, InterruptedException 
  {
	  
	  home.acbalance();
	  Reporter.log("Getting account Balance", true);
	  NeoStoxUtility.screenshot(driver, "AccountBalance01");
	  
	  NeoStoxUtility.Wait(driver, 2000);
	
	  
  }
 
  @Test(priority = -1)
  public void validatusername() throws IOException, InterruptedException
  {
	  Thread.sleep(2500);
	 Assert.assertEquals(home.getusername(), NeoStoxUtility.readdatafromproperties("name"));
	 Reporter.log("Validating username...", true);
	 NeoStoxUtility.Wait(driver, 2000);
	 NeoStoxUtility.screenshot(driver, "username01");
	 Reporter.log("Taking screenshot for username validation...", true);
	 NeoStoxUtility.Wait(driver, 2000);
	 
  }
  
  @AfterClass
  public void logout() throws InterruptedException
  {
	  logout.dropdown();
	
	  logout.clickonlogout();
	
	  Reporter.log("logging out...", true);
	  Thread.sleep(200);
	  
	  
  }
  
 @AfterTest
  public void closeBrowser() throws InterruptedException
  {
	 
	  Reporter.log("Closing Browser...", true);
	  driver.close();
	  Thread.sleep(2000);
  }
}
