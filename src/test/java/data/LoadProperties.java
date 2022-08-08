package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties 
{
	// load the properties from the file 
	public static Properties userData= LoadProperties
			(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\userdata1.properties");


	private static Properties LoadProperties(String path)
	{
		Properties pro= new Properties();
		// Stream for reading the file
		try {
			FileInputStream stream = new FileInputStream(path);
			pro.load(stream);

		} catch (FileNotFoundException e) {
			System.out.println("Error Occured : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error Occured : " + e.getMessage());
		}
		catch (NullPointerException e) {
			System.out.println("Error Occured : " + e.getMessage());
		}
		
		return pro;


	}

}
