package tests;

import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToShoppinCarttest extends TestBase 

{
	SearchPage searchObject;
	ProductDetailsPage productDetails;
	String ProductName = "Apple MacBook Pro 13-inch";
	ShoppingCartPage cartPage;
	
	
	
	@Test(priority = 1)
	public void userCanSearchWithautosuggest()
	{
		
			searchObject = new SearchPage(driver);
			searchObject.ProductSearchAutoSuggest("Mac");
			productDetails=new ProductDetailsPage(driver);
			//Assert.assertTrue(productDetails.ProductNameBreadCrumb.getText().contains("Mac"));
	}
		
		
	@Test(priority = 2)
		public void USerCanAddToShoppinCart() throws InterruptedException
		{
			productDetails = new ProductDetailsPage(driver);
			 productDetails.AddtoCart();
			 Thread.sleep(1000);
			 driver.navigate().to("https://demo.nopcommerce.com/cart");
			
			
		}

	@Test(priority = 3)
	public void userCanRemoveFromCart()
	{
		cartPage = new ShoppingCartPage(driver);
		cartPage.RemoveProducrFromCart();
		
	}


			
	}