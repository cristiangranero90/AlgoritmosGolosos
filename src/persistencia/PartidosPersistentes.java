package persistencia;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



import org.json.simple.JSONObject;

public class PartidosPersistentes {

	//Para GSON JSON
	public void lectura (FileReader file)
	{
		JSONParser parser = new JSONParser();

		try {
			Object obj= parser.parse(new FileReader("prueba.json"));
			
			JSONObject jsonobj= (JSONObject) obj;
			
			System.out.println("JSON leido"+ jsonobj);
			}

		 catch (FileNotFoundException e) {
			//manejo de error
		} catch (IOException e) {
			//manejo de error
		} catch (ParseException e) {
			System.out.println("se lanzó esta exception");
		}

	}
	
	
}
