package neoStoxPOMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeoStoxLogin 
{
	@FindBy(xpath = "(//input[@type='number'])[1]")private WebElement number;
	
	@FindBy(xpath = "(//a[text()='Sign In'])[2]")private WebElement signinbutton;
	
	@FindBy(xpath = "//input[@id='txt_accesspin']")private WebElement enterpin;
	
	@FindBy(xpath = "//a[@id='lnk_submitaccesspin']")private WebElement submitpin;
	
	//Create constructor for the class
	
	public NeoStoxLogin(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Create Method for Number
	public void number(String num)
	{
		number.sendKeys(num);
		Reporter.log("Entering Mobile Number...",true);
	}
	
	//Create Method for signinbutton
	public void signinbutton()
	{
		signinbutton.click();
		Reporter.log("Clicking on Sign in Button", true);
	}
	
	//Create Method For Enterpin
	public void enterpin(String pin)
	{
		enterpin.sendKeys(pin);
		Reporter.log("Entering Password...", true);
	}
	
	//Create method for submitbutton
	public void submitbutton() throws InterruptedException
	{
		submitpin.click();
		Reporter.log("Clicking on Submit button", true);
		Thread.sleep(2000);
	}
	
	
	
	
	
	
}

