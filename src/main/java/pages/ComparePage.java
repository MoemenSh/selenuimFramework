package pages;

import java.util.List;

import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends PageBase
{

	public ComparePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css = "a.clear-list")
	WebElement ClearListbtn;

	@FindBy(css = "div.page.compare-products-page")
	WebElement cmpTable;

	@FindBy(css = "div.no-data")
	public	WebElement noDataLbl;

	@FindBy(tagName = "tr")
	public List<WebElement> allRows;

	@FindBy(tagName = "td")
	public 	List<WebElement> allCol;

	public void ClearCompareList()
	{
		ClickBtn(ClearListbtn);
	}
	public void cmpProducts() 
	{
		//get All Rows
		System.out.println(allRows.size());
		//Get Data From Row
		for (WebElement row: allRows) 
		{
			System.out.println(row.getText()+"\t");
			for(WebElement col : allCol)
			{
				System.out.println(col.getText()+"\t");

			}
		}



	}
}
