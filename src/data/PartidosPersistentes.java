package data;

//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



//import org.json.simple.JSONObject;

public class PartidosPersistentes {

	//Para GSON JSON
	public void lectura (FileReader file)
	{
		//JSONParser parser = new JSONParser();
		JsonParser parser = new JsonParser();
		try {
			Object obj= parser.parse(new FileReader("prueba.json"));
			
			JsonObject jsonobj = (JsonObject) obj;
			//JSONObject jsonobj= (JSONObject) obj;
			
			System.out.println("JSON leido"+ jsonobj);
			}

		 catch (FileNotFoundException e) {
			//manejo de error
		} catch (IOException e) {
			//manejo de error
		} catch (JsonParseException e) {
			System.out.println(e.toString() + "se lanz� esta exception");
		}

	}
	
	
}
