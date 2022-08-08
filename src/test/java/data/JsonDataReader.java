package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDataReader 
{
	public String  fn;
	public String ln;
	public String email;
	public String passward;
	public void JsonReader() throws FileNotFoundException, IOException, ParseException
	{
		String FilePath= System.getProperty("user.dir")+ "/src/test/java/data/UserData.json";

		File srcfile= new File(FilePath);
		JSONParser parser = new JSONParser();
		JSONArray jarray = (JSONArray) parser.parse(new FileReader(srcfile));

		for (Object jsonobj : jarray) 
		{
			JSONObject person = (JSONObject) jsonobj;
			fn = (String) person.get("firstname");
			ln = (String) person.get("lastname");
			email = (String)person.get("email");
			passward= (String)person.get("pass");		 

		}

	}

}
