package data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import model.Campeonato;
import model.Club;
import model.Fecha;
import model.Partido;

public class CampeonatoPrueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Campeonato torneo=new Campeonato();
		JsonParser parser = new JsonParser();
		try {
			Object obj= parser.parse(new FileReader("C:\\Users\\Lorenzo\\Documents\\javaeclipse\\PROGRAMACION 3\\tp 3\\campeonato.json"));
			
			JsonObject jsonobj = (JsonObject) obj;
			//JSONObject jsonobj= (JSONObject) obj;
			
			
			System.out.println("JSON leido"+ jsonobj);
			ArrayList <String> ret=new ArrayList <String>();
			
			ret.add("Fecha1");
			ret.add("Fecha2");
			//ArrayList <String> equipos=new ArrayList <String>();
			for (String elem: ret)
			{
			JsonArray campeonato =jsonobj.getAsJsonArray(elem);
			JsonArray fecha =campeonato.getAsJsonArray();
			Fecha _fecha= new Fecha(1);
			ArrayList <String> equipos=new ArrayList <String>();
			
			for(int i=0;i<fecha.size();i++) {
				equipos.add(fecha.get(i).getAsString());
				
					
				//System.out.println(fecha);
			//	System.out.println("****************");		
			
			}
			for(int j=0;j<equipos.size()-1;j+=2) {
				Club club1= new Club (equipos.get(j));
				Club club2=  new Club (equipos.get(j+1));
				Partido par=new Partido (club1,club2);
				_fecha.agregarPartido(par);
				
			}
			
			
				torneo.agregarFechas(_fecha);
				
				
				
			
			
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
		
		System.out.println(torneo.toString());

	}
	


}
