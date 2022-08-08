package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase
{
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage productDetails;
	@Test
	public void UserCanSearchForProduct()
	{
		productDetails = new ProductDetailsPage(driver);
		searchObject= new SearchPage(driver);
		searchObject.productSearch(productName);
		searchObject.OpenProductDetailsPages();
		
		
	}

}
