package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase 
{

	public ProductReviewPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(id = "AddProductReview_Title")
	WebElement reviewTitleTxt;
	
	@FindBy(id = "AddProductReview_ReviewText")
	WebElement reviewTXT;
	
	@FindBy(id = "addproductrating_4")
	WebElement ratingbtn;
	
	@FindBy(name = "add-review")
	WebElement sumbitBtn;

	@FindBy(css = "div.result")
	public WebElement reviewNodfication;

	public void AddProductReview(String reviewTitle, String reviewMessg)
	{
		setTxt(reviewTitleTxt, reviewTitle);
		setTxt(reviewTXT, reviewMessg);
		ClickBtn(ratingbtn);
		ClickBtn(sumbitBtn);
	}

}
