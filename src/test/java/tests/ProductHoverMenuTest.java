package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverMenuTest extends TestBase
{
	HomePage homeObject;
	
	@Test
	public void userCanSelectSubCategory()
	{
		homeObject = new HomePage(driver);
		homeObject.SelectNoteBoxMenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}

}
