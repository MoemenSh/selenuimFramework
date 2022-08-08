package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ComparePage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToCompareTest extends TestBase 
{
	String firstProductName="Apple MacBook Pro 13-inch";
	String secondProductName="Asus N551JK-XO076H Laptop";

	/*
	 * 1- search for product no.1
	 * 2-search for product 2
	 * 3- add to compare
	 * 4-clear list 
	 */
	ProductDetailsPage detailsObject;
	HomePage homeObject;
	ComparePage compareObject;
	SearchPage searchObject;

	@Test(priority = 1)
	public void UserCanCompareProducts() throws InterruptedException
	{
		searchObject = new SearchPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		compareObject = new ComparePage(driver);

		searchObject.ProductSearchAutoSuggest("Mac");
		//Assert.assertTrue(detailsObject.ProductNameBreadCrumb.getText().contains(firstProductName));
		detailsObject.AddProductToCompare();

		searchObject.productSearch("Asus");
	
		//Assert.assertTrue(detailsObject.ProductNameBreadCrumb.getText().contains(secondProductName));
		detailsObject.AddProductToCompare();
		Thread.sleep(1000);
		
		driver.navigate().to("https://demo.nopcommerce.com/compareproducts");
		compareObject.cmpProducts();
	}

	@Test(priority = 2)
	public void UserCanClearCompareList()
	{
		compareObject.ClearCompareList();
		Assert.assertTrue(compareObject.noDataLbl.getText().contains("You have no items to compare."));
	}
}
