package neoStoxTestClasses;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import neoStoxBaseClasses.NeoStoxBase;
import neoStoxPOMclasses.NeoStoxHomePage;
import neoStoxPOMclasses.NeoStoxLogin;
import neoStoxPOMclasses.NeoStoxLogout;
import neoStoxPOMclasses.NeoStoxPopup;
import neoStoxPOMclasses.NeoStoxSearch;
import neoStoxPOMclasses.NeoStoxUtility;
import neoStoxPOMclasses.NeostoxMainPage;

public class ValidateSearchFunctionality extends NeoStoxBase 
{
	NeoStoxHomePage main;
	NeoStoxLogin login;
	NeostoxMainPage home;
	NeoStoxPopup welcome;
	NeoStoxSearch search;
	NeoStoxLogout logout;
	
  @BeforeTest
  public void OpenBrowser() throws IOException, InterruptedException
  {
	  BrowserLaunch();
	  Reporter.log("Launching Browser...", true);
	  
	  login = new NeoStoxLogin(driver);
	  home = new NeostoxMainPage(driver);
	  welcome = new NeoStoxPopup(driver);
	  search = new NeoStoxSearch(driver);
	  logout = new NeoStoxLogout(driver);
	  main = new NeoStoxHomePage(driver);
  }
  
  @BeforeClass
  public void login() throws IOException, InterruptedException
  {
	  main.signin();
	  login.number(NeoStoxUtility.readdatafromproperties("userID"));
	  Thread.sleep(200);
	  login.signinbutton();
	  Thread.sleep(200);
	  login.enterpin(NeoStoxUtility.readdatafromproperties("password"));
	  Thread.sleep(2000);
	  login.submitbutton();
	  Thread.sleep(100);
	  welcome.okbutton();
	  Thread.sleep(1000);
	  welcome.closebutton();
	  Reporter.log("Logging in...", true);
	  home.closepostiontab();
	  Thread.sleep(2000);
  }
	
  @Test
  public void validateSearch() throws InterruptedException, IOException 
  {
	search.search("TATA");
	Thread.sleep(400);
	search.sharename();
	Thread.sleep(400);
	search.clickonsearchicon();
	Thread.sleep(400);
	search.clickonshare();
	Thread.sleep(400);
	search.viewchart();
	Thread.sleep(400);
	NeoStoxUtility.screenshot(driver, "ShareChart");
	Reporter.log("Validating Search Field and Taking Screenshot", true);
  }
  
  
  @AfterClass
  public void logout() throws InterruptedException
  {
	  logout.dropdown();
	  Thread.sleep(500);
	  logout.clickonlogout();
	  Reporter.log("Logging Out...", true);
  }
  
  @AfterTest
  
  public void CloseBrowser()
  {
	  Reporter.log("Closing Browser...", true);
	  driver.close();
  }
  
}
