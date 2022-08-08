package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.errorprone.annotations.FormatMethod;

public class ProductDetailsPage extends PageBase 
{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "/apple-macbook-pro-13-inch")
	public WebElement ProductNameBreadCrumb;
	@FindBy(xpath = "//*[@id=\"product-details-form\"]/div[2]/div[1]/div[2]/div[10]/div[3]/button")
	WebElement sendByEmailBtn;
	@FindBy(id = "price-value-4")
	public WebElement productPriceLabel;
	
	@FindBy(linkText = "Add your review")
	WebElement addReviewLink;
	
	@FindBy(id = "add-to-wishlist-button-4")
	WebElement AddToWishBtn;
	
	@FindBy(css = "button.button-2.add-to-compare-list-button")
	WebElement addToCompareBtn;
	
	@FindBy(id = "add-to-cart-button-4")
	WebElement addtoCardbtn;
	

	public void sendEmail()
	{
		ClickBtn(sendByEmailBtn);
	}
	public void openAddReviewPage()
	{
		ClickBtn(addReviewLink);
	}
	public void addWishList()
	{
		ClickBtn(AddToWishBtn);
	}
	public void AddProductToCompare()
	{
		ClickBtn(addToCompareBtn);
	}
	public void AddtoCart()
	{
		ClickBtn(addtoCardbtn);
	}
}
