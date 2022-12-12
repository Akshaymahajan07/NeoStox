package neoStoxPOMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeoStoxLogout 
{
    @FindBy(id = "navbarDropdown")private WebElement dropdown;
	
	@FindBy(xpath = "//span[text()='Logout']")private WebElement logout;
	
	//Create Constructor for NeoStoxLogout
	public NeoStoxLogout(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Create Method for dropdown
		public void dropdown()
		{
			dropdown.click();
			Reporter.log("Clicking on Dropdown...", true);
		}
		
		//Create Method for Logout
		public void clickonlogout()
		{
			logout.click();
			Reporter.log("Clicking on logout Button...", true);
		}

}
