package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegisterationTestWithDDtandExcel extends TestBase 
{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	@DataProvider(name = "ExcelData")
	public Object[][] userRegisterData() throws IOException
	{
		//get data from excel
		ExcelReader ER = new ExcelReader();
		
			return ER.getExcelData();
		
	}
	
	
	
	@Test(priority = 1,alwaysRun = true, dataProvider = "ExcelData")
	public void UserCanregisterSuccessfully(String Fname, String lname, String email, String pass)
	{
		homeObject = new HomePage(driver);
		homeObject.OpenRegistrationPage();
		registerObject= new UserRegistrationPage(driver);
		registerObject.userRegister(Fname,lname,email,pass);
		Assert.assertTrue(registerObject.succesmessage.getText().contains("Your registration completed"));
		registerObject.UserLogOut();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email, pass);
		registerObject.UserLogOut();
	
	
	
	
	}	

}
