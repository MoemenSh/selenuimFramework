package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;



public class HomePage extends PageBase
{

	public HomePage(WebDriver driver) {
		super(driver);
		jse =(JavascriptExecutor) driver;
		action = new Actions(driver);
	}

	@FindBy(linkText = "Register")
	WebElement registerLink;

	@FindBy(linkText = "Log in")
	WebElement loginLink;
	@FindBy(linkText = "Contact us")
	public WebElement contactusBtn;

	@FindBy(id = "customerCurrency")
	WebElement currencyLi;
	
	@FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/a")
	WebElement computerMenus;
	
	@FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a" )
	WebElement noteBooksMenu;

	public void OpenRegistrationPage()
	{
		//registerLink.click();
		ClickBtn(registerLink);
	}

	public void openLoginPage()
	{
		ClickBtn(loginLink);
	}

	public void openContactUs()
	{
		scrollToBottom();
		contactusBtn.click();

	}
	public void ChangeCurrency()
	{
		select= new Select(currencyLi);
		select.selectByVisibleText("Euro");
		
	}
	public void SelectNoteBoxMenu()
	{
		action.moveToElement(computerMenus).
		moveToElement(noteBooksMenu).click()
		.build().perform();
	}

}
