package tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utility.Helper;

public class TestBase extends AbstractTestNGCucumberTests
{
	protected static WebDriver driver;

	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional("chrome") String browserName) 
	{
		if (browserName.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
			driver= new FirefoxDriver();			
		}
				
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com/");		
	}

	@AfterSuite
	public void TearDown()
	{
		driver.quit();
	}
	
	//after every time method runs takes screenshot when test fail
	@AfterMethod
	public void screenshotonFailure(ITestResult result)
	{
		if (result.getStatus() == ITestResult.FAILURE) 
		{
			System.out.println("failed");
			System.out.println("Taking ScreenShot.......");
			Helper.CaptureScreenShot(driver, result.getName());
		}
	}

}
