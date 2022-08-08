package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase
{

	public UserRegistrationPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(id = "gender-male")
	WebElement gender;
	
	@FindBy(id = "FirstName")
	WebElement FirstNametxt;
	
	@FindBy(id = "LastName")
	WebElement LastNametxt;
	
	@FindBy(id = "Email")
	WebElement Emailtxt;
	
	@FindBy(id = "Password")
	WebElement Passtxt;

	@FindBy(id = "ConfirmPassword")
	WebElement ConfirmPasstxt;
	
	@FindBy(id = "register-button")
	WebElement RegisterBtn;
	
	@FindBy(linkText = "My account")
	WebElement MyAccountLink;
	
	@FindBy(css = "div.result")
	public WebElement succesmessage;
	
	@FindBy(css = "a.ico-logout")
	public WebElement logoutLink;
	
	public void userRegister(String FirstNamer, String lastName, String email, String Pass)
	{
		ClickBtn(gender);
		setTxt(FirstNametxt, FirstNamer);
		setTxt(LastNametxt, lastName);
		setTxt(Passtxt, Pass);
		setTxt(Emailtxt, email);
		setTxt(ConfirmPasstxt, Pass);
		ClickBtn(RegisterBtn);
	}
	public void UserLogOut()
	{
		ClickBtn(logoutLink);
	}
	
	public void OpenMyAccountPage()
	{
		ClickBtn(MyAccountLink);
	}
	
	
}
