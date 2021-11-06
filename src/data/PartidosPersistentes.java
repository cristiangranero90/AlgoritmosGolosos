package data;


import com.google.gson.JsonArray;

//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import model.Campeonato;
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
	
	public Campeonato torneo;
	
	public Campeonato Lectura (){
		
		
		Campeonato torneo=new Campeonato();
		JsonParser parser = new JsonParser();
		try {
			Object obj= parser.parse(new FileReader("src/data/torneo2.json"));
			
			JsonObject jsonobj = (JsonObject) obj;
			//JSONObject jsonobj= (JSONObject) obj;
			
			
			ArrayList<String> ret = guardarEquipos();
			
			int contador=1;
			for (String elem: ret)
			{
			JsonArray campeonato =jsonobj.getAsJsonArray(elem);
			JsonArray fecha =campeonato.getAsJsonArray();
			
			Fecha _fecha= new Fecha(contador);
			ArrayList <String> equipos=new ArrayList <String>();
			
			for(int i=0;i<fecha.size();i++) {
				equipos.add(fecha.get(i).getAsString());
				
			}
			
			
			for(int j=0;j<equipos.size()-1;j+=2) {
				Club club1= new Club (equipos.get(j));
				Club club2=  new Club (equipos.get(j+1));
				Partido par=new Partido (club1,club2);
				_fecha.agregarPartido(par);
				
			}
			
			
				torneo.agregarFechas(_fecha);
				
				contador++;
				
			
			
			}
			
		}
		 catch (FileNotFoundException e) {
			//manejo de error
			 System.out.println("filenot");
		} catch (IOException e) {
			//manejo de error
			System.out.println("ioex");
		} catch (JsonParseException e) {
			System.out.println("jsonparce");
		}
		
		return torneo;

	}

	private ArrayList<String> guardarEquipos() {
		ArrayList <String> ret=new ArrayList <String>();
		
		ret.add("fecha 1");
		ret.add("fecha 2");
		ret.add("fecha 3");
		ret.add("fecha 4");
		ret.add("fecha 5");
		ret.add("fecha 6");
		ret.add("fecha 7");
		ret.add("fecha 8");
		ret.add("fecha 9");
		return ret;
	}
	

	
	
	
}
