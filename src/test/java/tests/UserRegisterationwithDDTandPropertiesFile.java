package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegisterationwithDDTandPropertiesFile extends TestBase 
{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String fn = LoadProperties.userData.getProperty("firstname"); 
	String ln = LoadProperties.userData.getProperty("lastname"); 
	String email = LoadProperties.userData.getProperty("email"); 
	String pass = LoadProperties.userData.getProperty("password"); 
	
	@Test(priority = 1,alwaysRun = true)
	public void UserCanregisterSuccessfully()
	{
		System.out.println(LoadProperties.userData);
		homeObject = new HomePage(driver);
		homeObject.OpenRegistrationPage();
		registerObject= new UserRegistrationPage(driver);
		registerObject.userRegister(fn,ln,email,pass);
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
		loginObject.UserLogin(email, pass);
	
		
		//Assert.assertTrue(registerObject.logoutLink.isDisplayed());
		//Assert.assertTrue(registerObject.logoutLink.getText().contains("Log"));


	}

}
