package tests;


import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchPriductUsingAutoSuggest extends TestBase
{
	SearchPage searchObject;
	ProductDetailsPage productDetails;
	
	@Test
	public void userCanSearchWithautosuggest()
	{
		try {
			searchObject = new SearchPage(driver);
			searchObject.ProductSearchAutoSuggest("Mac");
			productDetails=new ProductDetailsPage(driver);
			//Assert.assertTrue(productDetails.ProductNameBreadCrumb.getText().equals("Apple MacBook Pro 13-inch "));
			
		} catch (Exception e) {
			System.out.println("error occured" + e.getMessage());
		}
	
	}

}
