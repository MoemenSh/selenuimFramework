package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase 
{
	HomePage homeObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	@Test(priority = 2)
	public void userCanSearchWithautosuggest()
	{
		try {
			searchObject = new SearchPage(driver);
			searchObject.ProductSearchAutoSuggest("Mac");
			detailsObject =new ProductDetailsPage(driver);
			Assert.assertTrue(detailsObject.ProductNameBreadCrumb.getText().contains("Mac"));
			Assert.assertTrue(detailsObject.productPriceLabel.getText().contains("€"));
			System.out.println(detailsObject.productPriceLabel.getText());
			
		} catch (Exception e) {
			System.out.println("error occured" + e.getMessage());
		}
	
	}
	
	@Test(priority = 1)
	public void userCanChangeCurrency()
	{
		homeObject=new HomePage(driver);
		homeObject.ChangeCurrency();
	}

}
