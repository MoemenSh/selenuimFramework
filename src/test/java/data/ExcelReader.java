package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{
	static FileInputStream fis = null;
	public FileInputStream getFileInputStream()
	{
		String Filepath=System.getProperty("user.dir")+"/src/test/java/data/UserData.xlsx";
		File srcFile =  new File(Filepath);
		
		try {
			fis = new FileInputStream(srcFile);
			
		} catch (FileNotFoundException e) {
		System.out.println("Test Data File not Found : " + e.getMessage());
		System.exit(0);
		}
		return fis;
		
		
	}
	public Object[][] getExcelData() throws IOException
	{
		fis= getFileInputStream();
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		
		int totalNumRows= sheet.getLastRowNum()+1;
		int totalNumcols=4;
		
		String[][] arrayExcelData= new String[totalNumRows][totalNumcols];
		for (int i = 0; i < totalNumRows; i++) 
		{
			for (int j = 0; j < totalNumcols; j++) 
			{
				XSSFRow row = sheet.getRow(i);
				arrayExcelData[i][j]=row.getCell(j).toString();
				
			}
			
		}
		wb.close();
		return arrayExcelData;
	}

}
