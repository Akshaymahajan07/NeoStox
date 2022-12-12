package neoStoxTestClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import neoStoxBaseClasses.*;
import neoStoxPOMclasses.NeoStoxHomePage;
import neoStoxPOMclasses.NeoStoxLogin;
import neoStoxPOMclasses.NeoStoxLogout;
import neoStoxPOMclasses.NeoStoxPopup;
import neoStoxPOMclasses.NeoStoxUtility;
import neoStoxPOMclasses.NeostoxMainPage;





public class ValidateUsername extends NeoStoxBase
{
	NeoStoxLogin login;
	NeostoxMainPage home;
	NeoStoxPopup welcome;
	NeoStoxLogout logout;
	NeoStoxHomePage mainpage;

	@BeforeClass
	public void OpenBrowser() throws IOException, InterruptedException
	{
		BrowserLaunch();
		Reporter.log("Launchinng browser", true);
		login = new NeoStoxLogin(driver);
		home = new NeostoxMainPage(driver);
		welcome = new NeoStoxPopup(driver);
		logout = new NeoStoxLogout(driver);
		mainpage = new NeoStoxHomePage(driver);
	}
	
	@BeforeMethod
	public void login() throws IOException, InterruptedException
	{
		mainpage.signin();
		login.number(NeoStoxUtility.readdatafromproperties("userID"));
		login.signinbutton();
		NeoStoxUtility.Wait(driver, 2000);
		login.enterpin(NeoStoxUtility.readdatafromproperties("password"));
		Thread.sleep(2000);
		login.submitbutton();
		
		Reporter.log("Logging in....", true);
		
		NeoStoxUtility.Wait(driver, 2000);
		welcome.okbutton();
		welcome.closebutton();
		Reporter.log("Clicling on button", true);
		
	}

  @Test(priority = -1)
  public void validateusername() throws IOException 
  {
	  home.getusername();
	  Assert.assertEquals(home.getusername(), neoStoxPOMclasses.NeoStoxUtility.readdatafromproperties("name") );
	  NeoStoxUtility.Wait(driver, 1000);
	  NeoStoxUtility.screenshot(driver, "NeoTC001");
	  NeoStoxUtility.Wait(driver, 2000);
	  Reporter.log("Validating username and taking screenshot", true);
	  
	  
  }
  
  @Test
  public void validateAccountBalance() throws IOException, InterruptedException
  {
	  home.acbalance();
	 
	  NeoStoxUtility.Wait(driver, 2000);
	  NeoStoxUtility.screenshot(driver, "NeoTC005");
	  Reporter.log("Validating Account Balance and Taking Screenshot", true);
	  neoStoxPOMclasses.NeoStoxUtility.Wait(driver, 2000);
	  Thread.sleep(2000);
  }
  
  @AfterMethod
  public void logout() throws InterruptedException
  {
	  logout.dropdown();
	  Thread.sleep(2000);
	  logout.clickonlogout();
	  Reporter.log("Logging Out.....");
  }
  
  @AfterClass
  public void closeBrowser()
  {
	 
	  driver.close();
	  Reporter.log("Closing Browser.....", true);
  }
}
