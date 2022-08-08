package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class EmailFriendTest extends TestBase
{
	//1-user Registeration

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	SearchPage searchObject;
	ProductDetailsPage productDetails;
	EmailPage  emailObject;

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


	//3- email the product for a friend
	@Test(priority = 3)
	public void RegisteredUSerCanSendEmailTOFriend()
	{
		productDetails.sendEmail();
		emailObject = new EmailPage(driver);
		emailObject.SendEmailToFriend("test@test.com", "hello friend");
		Assert.assertTrue(emailObject.MessageNodfication.getText().contains("Your message"));
	}

	//4- UserLogOut
	@Test(priority = 4)
	public void RegisterUserCanLogOut()
	{
		registerObject.UserLogOut();
	}

}
