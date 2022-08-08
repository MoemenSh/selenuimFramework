package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUs;
import pages.HomePage;

public class ContactUsTest  extends TestBase
{
	HomePage home;
	ContactUs contactus;
	String name="Moemen Ahmed ";
	String Email = "nien@test.com";
	String Message = "hello admin, qc testing";
	@Test
	public void UserCanContactUS()
	{
		home=new HomePage(driver);
		home.openContactUs();
		contactus =  new ContactUs(driver);
		contactus.ContactUs(name, Email, Message);
	
		Assert.assertTrue(contactus.succesmsg.getText().contains("store owner."));
		
		
		
}}