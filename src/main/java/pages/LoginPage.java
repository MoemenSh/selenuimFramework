package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase
{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "Email")
	WebElement EmailTxtlogin;
	
	@FindBy(id = "Password")
	WebElement PassTxtLogin;
	
	@FindBy(css = "button.button-1")
	WebElement loginbtn;
	
	public void UserLogin(String email, String pass)
	{
		setTxt(EmailTxtlogin,email);
		setTxt(PassTxtLogin, pass);
		ClickBtn(loginbtn);
	}

}
