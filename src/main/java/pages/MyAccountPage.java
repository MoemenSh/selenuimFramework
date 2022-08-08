package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (linkText = "Change password")
	WebElement changePasswordLink;	
	@FindBy(id = "OldPassword")
	WebElement OldPasstxt;	
	@FindBy(id = "NewPassword")
	WebElement NewPassTxt;
	@FindBy(id = "ConfirmNewPassword")
	WebElement ConfirmPass;
	@FindBy(css = "button.button-1.change-password-button")
	WebElement ChangePassbtn;
	@FindBy(id = "bar-notification")
	public WebElement PassChangeResult;
	@FindBy(css = "span.close")
	public WebElement close;

	public void OpenChangePasswordPage()
	{
		ClickBtn(changePasswordLink);
	}
	public void ChangePassword(String oldpass, String NewPass)
	{
		setTxt(OldPasstxt, oldpass);
		setTxt(NewPassTxt, NewPass);
		setTxt(ConfirmPass, NewPass);
		ClickBtn(ChangePassbtn);
		
		
	}


}

