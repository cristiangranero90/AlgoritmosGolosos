package data;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import model.Campeonato;
import model.Club;
import model.Fecha;
import model.Partido;
import presenter.Contract;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PartidosPersistentes {
	
	public Campeonato torneo;
	
	public static ArrayList<String> leerNombres() {
		JsonParser parser = new JsonParser();
		ArrayList<String> ret = new ArrayList<>();
		try {
			Object obj= parser.parse(new FileReader("src/data/nombres.json"));			
			JsonObject jsonobj = (JsonObject) obj;				
			JsonArray nombres = jsonobj.getAsJsonArray("Arbitros");
			for (int i = 0; i < nombres.size(); i++) {
				ret.add(nombres.get(i).getAsString());
			}
		}
		catch (Exception e){
			System.err.println(e.toString());
		}
		return ret;
	}
	
	@SuppressWarnings("deprecation")
	public static Campeonato Lectura (Contract.Presenter presenter){	
		
		Campeonato torneo=new Campeonato(presenter);
		JsonParser parser = new JsonParser();
		try {
			
			Object obj= parser.parse(new FileReader("src/data/torneo2.json"));			
			JsonObject jsonobj = (JsonObject) obj;			
			ArrayList<String> ret = guardarEquipos();
			
			int contador=1;
			for (String elem: ret) {
				JsonArray campeonato =jsonobj.getAsJsonArray(elem);
				JsonArray fecha =campeonato.getAsJsonArray();
			
				Fecha _fecha= new Fecha(contador);
			
				ArrayList <String> equipos=new ArrayList <String>();			
				construirEquipos(fecha, _fecha, equipos);	
			
				torneo.agregarFechas(_fecha);
				
				contador++;			
			}
			
		}
		
		 catch (FileNotFoundException e) {
			 System.out.println(e.toString());
		} catch (@SuppressWarnings("hiding") IOException et) {
			System.out.println(et.toString());
		} catch (JsonParseException e) {
			System.out.println(e.toString());
		}
		
		return torneo;

	}

	private static void construirEquipos(JsonArray fecha, Fecha _fecha, ArrayList<String> equipos) {
		for(int i=0;i<fecha.size();i++) {
			equipos.add(fecha.get(i).getAsString());				
		}
		
		for(int j=0;j<equipos.size()-1;j+=2) {
			Club club1= new Club (equipos.get(j));
			Club club2=  new Club (equipos.get(j+1));
			Partido par=new Partido (club1,club2);
			_fecha.agregarPartido(par);
			
		}
	}

	private static ArrayList<String> guardarEquipos() {
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
