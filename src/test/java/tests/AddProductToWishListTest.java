package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProductToWishListTest extends TestBase 
{
	SearchPage searchPage;
	ProductDetailsPage productdetails;
	WishListPage wishlistobject;
	String ProductName = "Apple MacBook Pro 13-inch";

	@Test(priority = 1)
	public void userCanSearchWithautosuggest()
	{
		try {
			searchPage = new SearchPage(driver);
			searchPage.ProductSearchAutoSuggest("Mac");
			productdetails=new ProductDetailsPage(driver);
			//Assert.assertTrue(productDetails.ProductNameBreadCrumb.getText().equals("Apple MacBook Pro 13-inch "));
			
		} catch (Exception e) {
			System.out.println("error occured" + e.getMessage());
		}
	
	}

	@Test(priority = 2)
	public void UserCanAddProducttoWishList()
	{
		productdetails = new ProductDetailsPage(driver);
		productdetails.addWishList();
		driver.navigate().to("https://demo.nopcommerce.com/"+"wishlist");
		//https://demo.nopcommerce.com/wishlist
		wishlistobject = new WishListPage(driver);
		Assert.assertTrue(wishlistobject.wishListHeader.isDisplayed());
		Assert.assertTrue(wishlistobject.productCell.getText().contains(ProductName));
	}

	@Test(priority = 3)
	public void UserCanRemoveFromWishList()
	{
		wishlistobject = new WishListPage(driver);
		wishlistobject.removeProductFromCart();
	}
}
