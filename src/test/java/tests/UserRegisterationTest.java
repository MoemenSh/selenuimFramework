package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegisterationTest extends TestBase 
{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	@Test(priority = 1,alwaysRun = true)
	public void UserCanregisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.OpenRegistrationPage();
		registerObject= new UserRegistrationPage(driver);
		registerObject.userRegister("Moemen", "Ahmed", "testemail12222226@gmai.com","12345678");
		Assert.assertTrue(registerObject.succesmessage.getText().contains("Your registration completed"));
	}
	@Test(dependsOnMethods = {"UserCanregisterSuccessfully"})
	public void RegisterUserCanLogOut()
	{
		registerObject.UserLogOut();
	}
	@Test(dependsOnMethods = {"RegisterUserCanLogOut"})
	public void RegisteredUserCanLoggedIn() 
	{

		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin("testemail12222226@gmai.com", "12345678");
	
		
		//Assert.assertTrue(registerObject.logoutLink.isDisplayed());
		//Assert.assertTrue(registerObject.logoutLink.getText().contains("Log"));


	}

}
