package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase 
{

	public ShoppingCartPage(WebDriver driver) {
		super(driver);

	}
	@FindBy(css = "button.remove-btn")
	WebElement removeCheck ;

	@FindBy(id = "updatecart")
	WebElement updateCartBtn;

	@FindBy(name = "itemquantity11215")
	public WebElement qunatitTxt ;

	@FindBy(css = "span.product-subtotal")
	public WebElement totalCheck ;
	
	@FindBy(id = "checkout")
	WebElement checkoutBTn;
	
	@FindBy(id = "termsofservice")
	WebElement agreeCheckBox;

	public void RemoveProducrFromCart()
	{
		ClickBtn(updateCartBtn);
		ClickBtn(removeCheck);

	}

	public void UpdateProducatQuantityIncart(String quantity)
	{
		clearTXT(qunatitTxt);
		setTxt(qunatitTxt, quantity);
		ClickBtn(updateCartBtn);
	}
	
	public void openCheckOutPage()
	{
		ClickBtn(agreeCheckBox);
		ClickBtn(checkoutBTn);
	}

	}