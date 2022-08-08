package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase
{

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "small-searchterms")
	WebElement searchElmentBox;
	@FindBy(css = "button.button-1.search-box-button")
	WebElement searchbtn;
	@FindBy(id = "ui-id-1")
	List<WebElement> ProductList;
	@FindBy(linkText =  "Apple MacBook Pro 13-inch")
	WebElement productTitle;
	public void productSearch(String productName )
	{
		setTxt(searchElmentBox, productName);
		ClickBtn(searchbtn);		
	}
	
	public void OpenProductDetailsPages()
	{
		ClickBtn(productTitle);
	}
	public void ProductSearchAutoSuggest( String searchTxt) 
	{
		setTxt(searchElmentBox, searchTxt);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ProductList.get(0).click();
		
	}

}
