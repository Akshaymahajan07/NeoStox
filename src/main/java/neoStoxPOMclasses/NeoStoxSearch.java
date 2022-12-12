package neoStoxPOMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeoStoxSearch 
{
    @FindBy(id = "txt_instruments")private WebElement search;
	
	@FindBy(xpath = "(//a[@class='label-dropdown'])[1]")private WebElement sharename;
	
	@FindBy(xpath = "//div[@class='d-flex px-2 pt-2 pb-0 bg-main']")private WebElement clickonshare;
	
	@FindBy(xpath = "//span[@id='sb_chartbtn871681']")private WebElement viewChart;
	
	@FindBy(xpath = "//span[@id='txtinstrumentaddon']")private WebElement clickonserchicon;
	
	@FindBy(xpath = "//span[@id='sb_chartbtn871681']")private WebElement openchart;
	
	
	//Create Constructor for SearchFuncationality
	public NeoStoxSearch(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Create Method for search
		public void search(String sharename)
		{
			search.sendKeys(sharename);
			Reporter.log("Entering Sharename...", true);
			
		}
		
		//Create Method for Sharename
		public void sharename()
		{
			sharename.click();
			Reporter.log("Clickin on ShareName...", true);
		}
		
		//Create Method for Click on share
		public void clickonshare()
		{
			clickonshare.click();
			Reporter.log("Click on Share...", true);
		}
		
		//Create Method for view chart
		public void viewchart()
		{
			viewChart.click();
			Reporter.log("Clicking on View Chart", true);
		}
		//create method for Clickonsearchicon
		public void clickonsearchicon()
		{
			clickonserchicon.click();
		}

}
