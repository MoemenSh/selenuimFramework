package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegisterationWithDataDriverTestandDataProvider extends TestBase 
{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	@DataProvider(name="testData")
	public static Object[][] userData()
	{
		return new Object[][] {
				{"Moemen" , "Shora" , "test2333322@test.com", "123456"	},
				{"ahmed","ali","test13322332@td.com","123456"}
				};
	}	
	
	
	
	@Test(priority = 1,alwaysRun = true, dataProvider = "testData")
	public void UserCanregisterSuccessfully(String Fname, String lname, String email, String pass) throws InterruptedException
	{
		homeObject = new HomePage(driver);
		homeObject.OpenRegistrationPage();
		registerObject= new UserRegistrationPage(driver);
		registerObject.userRegister(Fname,lname,email,pass);
		//Assert.assertTrue(registerObject.succesmessage.getText().contains("Your registration completed"));
		registerObject.UserLogOut();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email,pass);
		Thread.sleep(3000);
		registerObject.UserLogOut();
	}
	

}
