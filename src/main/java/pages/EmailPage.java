package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends PageBase
{

	public EmailPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "FriendEmail")
	WebElement emailFirendTxt;
	
	@FindBy(id = "PersonalMessage")
	WebElement personalMessageTxt;
	@FindBy(name = "send-email")
	WebElement sendEmailBtn;
	@FindBy(css = "div.result")
	public WebElement MessageNodfication;
	
	public void SendEmailToFriend(String friendEMail , String Message)
	{
		setTxt(emailFirendTxt, friendEMail);
		setTxt(personalMessageTxt, Message);
		ClickBtn(sendEmailBtn);
	}

}
