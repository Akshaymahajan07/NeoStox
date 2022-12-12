package neoStoxPOMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeoStoxTradePanel 
{
	@FindBy(id = "lnk_openpositions")private WebElement activePosition;
	
	@FindBy(id = "lnk_pendingorders")private WebElement pendingOrder;
	
	@FindBy(id = "lnk_completedorders")private WebElement dayhistory;
	
	@FindBy(xpath = "//div[@class='graphminusbtn']/span[2]")private WebElement todayprofitloss;
	
	@FindBy(xpath = "//div[@class='graphminusbtn']/span[4]")private WebElement allprofitloss;
	
	//Create Constructor for NeoStoxTradePanel
	public NeoStoxTradePanel(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Create Method for ActivePostion
	public void activePostion()
	{
		activePosition.click();
		Reporter.log("Clicking on active Postions tab...", true);
	}
	
	//Create Method For pendingOrder
	public void pendingOrder()
	{
		pendingOrder.click();
		Reporter.log("Clicking on Pending Orders tab...", true);
	}
	
	//Create Method for dayhistotry
	public void dayhistory()
	{
		dayhistory.click();
		Reporter.log("Clicking on Day History tab...", true);
	}
	
	//create Method for todayprofitloss
	public String todayprofitloss()
	{
		String todayPL=todayprofitloss.getText();
		Reporter.log("Getting today's P/L...", true);
		Reporter.log("Today's P/L is "+todayPL, true);
		return todayPL;
	}
	
	//Create Method for AllprofitLoass
	public String allprofitloss()
	{
		String PL = allprofitloss.getText();
		Reporter.log("Getting all P/L...", true);
		Reporter.log("P/L of active postion is "+PL, true);
		return PL;
	}
	
	
}
