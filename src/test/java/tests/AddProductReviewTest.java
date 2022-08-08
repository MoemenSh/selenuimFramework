package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class AddProductReviewTest extends TestBase
{
	/*
	 * 1-user registeration
	 * 2-search for product
	 * 3-add review
	 * 4-logout
	 */

	//1-user Registeration

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	SearchPage searchObject;
	ProductDetailsPage productDetails;
	ProductReviewPage ReviewObject;


	@Test(priority = 1,alwaysRun = true)
	public void UserCanregisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.OpenRegistrationPage();
		registerObject= new UserRegistrationPage(driver);
		registerObject.userRegister("Moemen", "Ahmed", "testemail21326@gmai.com","12345678");
		Assert.assertTrue(registerObject.succesmessage.getText().contains("Your registration completed"));
	}

	// 2-search for product

	@Test(priority = 2)
	public void userCanSearchWithautosuggest()
	{
		try {
			searchObject = new SearchPage(driver);
			searchObject.ProductSearchAutoSuggest("Mac");
			productDetails=new ProductDetailsPage(driver);
			//Assert.assertTrue(productDetails.ProductNameBreadCrumb.getText().contains("Mac"));

		} catch (Exception e) {
			System.out.println("error occured" + e.getMessage());
		}

	}


	//3- Add Review
	@Test(priority = 3)
	public void registeredUserCanAddReview()
	{
		productDetails.openAddReviewPage();
		ReviewObject = new ProductReviewPage(driver);
		ReviewObject.AddProductReview("new review", "the product is good");
		Assert.assertTrue(ReviewObject.reviewNodfication.getText()
				.contains("Product review is successfully"));
	}

	//4- UserLogOut
	@Test(priority = 4)
	public void RegisterUserCanLogOut()
	{
		registerObject.UserLogOut();
	}


}
