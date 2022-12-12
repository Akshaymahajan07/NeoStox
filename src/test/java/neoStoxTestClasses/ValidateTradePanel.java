package neoStoxTestClasses;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import neoStoxBaseClasses.NeoStoxBase;
import neoStoxPOMclasses.NeoStoxHomePage;
import neoStoxPOMclasses.NeoStoxLogin;
import neoStoxPOMclasses.NeoStoxLogout;
import neoStoxPOMclasses.NeoStoxPopup;
import neoStoxPOMclasses.NeoStoxTradePanel;
import neoStoxPOMclasses.NeoStoxUtility;
import neoStoxPOMclasses.NeostoxMainPage;

public class ValidateTradePanel extends NeoStoxBase
{
	NeoStoxHomePage home;
	NeoStoxLogin login;
	NeoStoxPopup welcome;
	NeoStoxTradePanel trade;
	NeoStoxLogout logout;
	
	@BeforeClass
	public void OpenBrowser() throws IOException, InterruptedException
	{
		BrowserLaunch();
		Reporter.log("Openinng Browser...",true);
		home = new NeoStoxHomePage(driver);
		login = new NeoStoxLogin(driver);
		welcome = new NeoStoxPopup(driver);
		trade = new NeoStoxTradePanel(driver);
		logout = new NeoStoxLogout(driver);
	

	}
	
	@BeforeMethod
	public void Login() throws IOException, InterruptedException
	{
		home.signin();
		login.number(NeoStoxUtility.readdatafromproperties("userID"));
		login.signinbutton();
		Thread.sleep(500);
		login.enterpin(NeoStoxUtility.readdatafromproperties("password"));
		Thread.sleep(2000);
		login.submitbutton();
		welcome.okbutton();
		Thread.sleep(1000);
		welcome.closebutton();
		Reporter.log("Logging in...", true);
	}
	
    @Test
    public void ValidateTradePanel() throws InterruptedException, IOException 
    {
    	trade.activePostion();
    	NeoStoxUtility.screenshot(driver, "NeoActivePostion");
    	Thread.sleep(1000);
    	trade.pendingOrder();
    	NeoStoxUtility.screenshot(driver, "NeoPendingOrders");
    	Thread.sleep(1000);
    	trade.dayhistory();
    	NeoStoxUtility.screenshot(driver, "NeoDayHostory");
    	Thread.sleep(1000);
    	trade.todayprofitloss();
    	Thread.sleep(500);
    	trade.allprofitloss();
    	Reporter.log("Validating tradePanel and Taking screenshots...", true);
    }
    
    @AfterMethod
    public void logout() throws InterruptedException
    {
    	logout.dropdown();
    	Thread.sleep(1000);
    	logout.clickonlogout();
    	Reporter.log("Logging in...", true);
    }
    
    @AfterClass
    public void CloseBrowser() throws InterruptedException
    {
    	Thread.sleep(1000);
    	Reporter.log("Closing Browser...", true);
    	driver.close();
    	
    }
}
