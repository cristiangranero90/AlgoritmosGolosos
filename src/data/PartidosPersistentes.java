package data;


import com.google.gson.JsonArray;

//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import model.Club;
import model.Fecha;
import model.Partido;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;



//import org.json.simple.JSONObject;

public class PartidosPersistentes {

	//Para GSON JSON
	public static void main(String[] args) {
		
		Map partido= new HashMap<String,String> ();
		Fecha fecha1=new Fecha(1);
	
		//JSONParser parser = new JSONParser();
		JsonParser parser = new JsonParser();
		try {
			Object obj= parser.parse(new FileReader("C:\\Users\\Lorenzo\\Documents\\javaeclipse\\PROGRAMACION 3\\tp 3\\fecha.json"));
			
			JsonObject jsonobj = (JsonObject) obj;
			//JSONObject jsonobj= (JSONObject) obj;
			
			
			System.out.println("JSON leido"+ jsonobj);
			
			JsonArray fecha =jsonobj.getAsJsonArray("fecha");
			for(int i=0;i<fecha.size();i++) {
				
				
				Club club1= new Club (fecha.get(i).getAsString());
				Club club2= new Club (fecha.get(i+1).getAsString());
				Partido par=new Partido (club1,club2);
				fecha1.agregarPartido(par);}
				
				
				
				
			
			
			}

		 catch (FileNotFoundException e) {
			//manejo de error
		} catch (IOException e) {
			//manejo de error
		} catch (JsonParseException e) {
			
		}
		
		fecha1.toString();

	}
	
	public static boolean esPar(int numero) {
	    if (numero % 2 == 0) {
	        return true;
	    } else {
	        return false;
	    }
	}
	
	
}
