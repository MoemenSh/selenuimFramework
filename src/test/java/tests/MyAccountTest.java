package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase
{

	HomePage homeObject;
	UserRegistrationPage registerObject;
	MyAccountPage myaccountobject;
	LoginPage loginObject;
	String oldpass="123456";
	String newpass="1234567";
	String fnName="Moemen";
	String LnName="shora";
	String Email="test22321@test.com";
	
	
	@Test(priority = 1)
	public void UserCanregisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.OpenRegistrationPage();
		registerObject= new UserRegistrationPage(driver);
		registerObject.userRegister(fnName, LnName, Email,oldpass);
		Assert.assertTrue(registerObject.succesmessage.getText().contains("Your registration completed"));
	}
	
	@Test(priority = 2)
	public void RegisteredUserCanChangePass() throws InterruptedException
	{
		myaccountobject=new MyAccountPage(driver);
		registerObject.OpenMyAccountPage();
		myaccountobject.OpenChangePasswordPage();
		myaccountobject.ChangePassword(oldpass, newpass);
		Assert.assertTrue(myaccountobject.PassChangeResult.getText().contains("Password"));
		Thread.sleep(3000);
	}
	@Test(priority = 3)
	public void RegisterUserCanLogOut()
	{
		myaccountobject=new MyAccountPage(driver);
		myaccountobject.close.click();
		registerObject.UserLogOut();
	}
	@Test(priority = 4)
	public void RegisteredUserCanLoggedIn() 
	{

		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(Email, newpass);
	
		
		//Assert.assertTrue(registerObject.logoutLink.isDisplayed());
		//Assert.assertTrue(registerObject.logoutLink.getText().contains("Log"));


	}


}
