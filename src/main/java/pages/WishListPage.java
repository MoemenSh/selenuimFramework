package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class WishListPage extends PageBase 
{

	public WishListPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "td.product")
	public WebElement productCell;
	
	@FindBy(css = "h1")
	public WebElement wishListHeader;
	
	@FindBy(id =  "updatecart")
	WebElement updateCart;
	
	@FindBy(name = "removefromcart")
	WebElement removeFromCart;
	
	@FindBy(css = "div.no-data")
	public WebElement EmptyCart;
	
	public void removeProductFromCart()
	{
		ClickBtn(updateCart);
		ClickBtn(removeFromCart);
		
		
	}
	
	

}
