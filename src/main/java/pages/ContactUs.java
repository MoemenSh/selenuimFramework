package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUs extends PageBase 
{

	public ContactUs(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(id = "FullName")
	WebElement FullNametxt;
	
	@FindBy(id = "Email")
	WebElement Emailtxt;
	@FindBy(id = "Enquiry")
	WebElement enquiryTxt;
	
	@FindBy(name = "send-email")
	WebElement submitbtn;
	 @FindBy(css = "div.result")
	public WebElement succesmsg;
	 
	 public void ContactUs(String Fullname, String Email, String msg)
	 {
		 setTxt(FullNametxt, Fullname);
		 setTxt(Emailtxt, Email);
		 setTxt(enquiryTxt, msg);
		 ClickBtn(submitbtn);
		 
		 
	 }
}

