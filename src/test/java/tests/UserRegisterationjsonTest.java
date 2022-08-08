package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegisterationjsonTest extends TestBase 
{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	@Test(priority = 1,alwaysRun = true)
	public void UserCanregisterSuccessfully() throws FileNotFoundException, IOException, ParseException
	{
		JsonDataReader jsreader = new JsonDataReader();
		jsreader.JsonReader();
		
		
		homeObject = new HomePage(driver);
		homeObject.OpenRegistrationPage();
		registerObject= new UserRegistrationPage(driver);
		registerObject.userRegister(jsreader.fn, jsreader.ln,jsreader.email, jsreader.passward);
		Assert.assertTrue(registerObject.succesmessage.getText().contains("Your registration completed"));
		registerObject.UserLogOut();
	
	
	
	}
	
	

	

}
