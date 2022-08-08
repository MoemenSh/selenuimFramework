package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegisterationWithJavaFaker extends TestBase 
{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	Faker fakeData = new Faker();
	String Fname= fakeData.name().firstName();
	String lname = fakeData.name().lastName();
	String email = fakeData.internet().emailAddress();
	String pass= fakeData.number().digits(8).toString();
	
	@Test(priority = 1,alwaysRun = true)
	public void UserCanregisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.OpenRegistrationPage();
		registerObject= new UserRegistrationPage(driver);
		registerObject.userRegister(Fname, lname,email,pass);
		System.out.println("the user Data is : " + Fname + "  "+ lname+ "  "+ email + "  " + pass + "    " );
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
		loginObject.UserLogin(email,pass);
	
		
		//Assert.assertTrue(registerObject.logoutLink.isDisplayed());
		//Assert.assertTrue(registerObject.logoutLink.getText().contains("Log"));


	}

}
