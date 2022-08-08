package tests;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegisterationTestCSV extends TestBase 
{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;

	CSVReader reader;



	@Test(priority = 1,alwaysRun = true)
	public void UserCanregisterSuccessfully() throws CsvValidationException, IOException
	{
		String CSV_file=System.getProperty("user.dir")+"/src/test/java/data/USerData.csv";
		reader = new CSVReader(new FileReader(CSV_file));

		String[] csvCell;
		while ((csvCell = reader.readNext()) != null ) 
		{
			String fname=csvCell[0];
			String lname= csvCell[1];
			String email=csvCell[2];
			String pass= csvCell[3];


			homeObject = new HomePage(driver);
			homeObject.OpenRegistrationPage();
			registerObject= new UserRegistrationPage(driver);
			registerObject.userRegister(fname,lname,email,pass);
			Assert.assertTrue(registerObject.succesmessage.getText().contains("Your registration completed"));
			registerObject.UserLogOut();
		/*	homeObject.openLoginPage();
			loginObject = new LoginPage(driver);
			loginObject.UserLogin(email, pass);
			registerObject.UserLogOut();


*/		}

	}

}
