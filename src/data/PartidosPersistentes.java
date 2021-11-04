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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;



//import org.json.simple.JSONObject;

public class PartidosPersistentes {

	//Para GSON JSON
	ArrayList<Partido> todosLosPartidos;
	
	public ArrayList<Partido> Lectura (){
		
		
		ArrayList <Partido>todosLosPartidos= new ArrayList<Partido> ();
	
		//JSONParser parser = new JSONParser();
		JsonParser parser = new JsonParser();
		try {
			Object obj= parser.parse(new FileReader("src/data/calendario2.json"));
			
			JsonObject jsonobj = (JsonObject) obj;
			//JSONObject jsonobj= (JSONObject) obj;
			
			
			System.out.println("JSON leido"+ jsonobj);
			
			JsonArray fecha =jsonobj.getAsJsonArray("fechas1");
			for(int i=0;i<fecha.size()-1;i+=2) {
				System.out.println(i);
				
				
				Club club1= new Club (fecha.get(i).getAsString());
				Club club2= new Club (fecha.get(i+1).getAsString());
				Partido par=new Partido (club1,club2);
				todosLosPartidos.add(par);
			}
				
				
				
				
			
			
			}

		 catch (FileNotFoundException e) {
			//manejo de error
		} catch (IOException e) {
			//manejo de error
		} catch (JsonParseException e) {
			
		}
		
		return todosLosPartidos;

	}
	

	
	
	
}
