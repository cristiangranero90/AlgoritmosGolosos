package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

public class Solver {
	
	private Campeonato instanciaCampeonato;
	private HashMap<Club, Arbitro> cantidadAparicionesArbitros;
	private Comparator<Arbitro> estrategiaActual;
	
	public Solver(Campeonato campeonato, Comparator<Arbitro> estrategia){
		setInstanciaCampeonato(campeonato);
		cantidadAparicionesArbitros = new HashMap<>();
		estrategiaActual = estrategia;
	}
	
	public Solucion resolver() {
		
		Solucion ret = new Solucion();
		ArrayList<Arbitro> todosLosArbitros = getInstanciaCampeonato().getArbitrosDisponibles();
		ArrayList<Fecha> fechasDisponibles = getInstanciaCampeonato().getFechas();
		ret.setArbitrosTotal(todosLosArbitros.size());
		int indiceArbitros = 0;
		
		
		for (Fecha unaFecha : fechasDisponibles) {	
			todosLosArbitros = ordenarArbitros(todosLosArbitros);
			
			for (Partido partidoActual : unaFecha.getPartidos()) {
				if (indiceArbitros < todosLosArbitros.size()) {						
					
					todosLosArbitros.get(indiceArbitros).setPremios(1);
					
					todosLosArbitros.get(indiceArbitros)
					.setAparicion(todosLosArbitros.get(indiceArbitros).getAparicion()+1);
					
					agregarPartidosArbitros(todosLosArbitros, indiceArbitros, partidoActual);
					
					ret.agregarArbitroSolucion(todosLosArbitros.get(indiceArbitros));					
					
					cantidadAparicionesArbitros.put(partidoActual.getEncuentro()[0], todosLosArbitros.get(indiceArbitros));
					indiceArbitros++;
				}
				
				else {					
					indiceArbitros = 0;	
					
					agregarPartidosArbitros(todosLosArbitros, indiceArbitros, partidoActual);
					
					
					todosLosArbitros.get(indiceArbitros).setPremios(1);	
					
					todosLosArbitros.get(indiceArbitros)
					.setAparicion(todosLosArbitros.get(indiceArbitros).getAparicion()+1);
					
					ret.agregarArbitroSolucion(todosLosArbitros.get(indiceArbitros));					
					
					cantidadAparicionesArbitros.put(partidoActual.getEncuentro()[0], todosLosArbitros.get(indiceArbitros));
					indiceArbitros++;
				}
			}
		}
		agregarClubArbitro(ret);
		return ret;
	}

	private void agregarPartidosArbitros(ArrayList<Arbitro> todosLosArbitros, int indiceArbitros,
			Partido partidoActual) {
		todosLosArbitros.get(indiceArbitros).agregarApariciones(partidoActual.getEncuentro()[0]);
		todosLosArbitros.get(indiceArbitros).agregarApariciones(partidoActual.getEncuentro()[1]);
	}

	private void agregarClubArbitro(Solucion ret) {
		Iterator<Club> iteClub = getAsignacionArbitros().keySet().iterator();
		
		while (iteClub.hasNext()) {
			Club auxClub = (Club) iteClub.next();
			int max = 0;
			Arbitro nuevo = getAsignacionArbitros().get(auxClub);
			if (nuevo.getAparicion() > max) {
				max = nuevo.getAparicion();
				ret.agregarAparicionesClub(auxClub, nuevo.getAparicion());
			}			
		}		
	}	

	public ArrayList<Arbitro> ordenarArbitros(ArrayList<Arbitro> arbitrosDisponibles) {
		ArrayList<Arbitro> ret = arbitrosDisponibles;
		Collections.sort(ret, estrategiaActual);		
		return ret;
	}

	public void setInstanciaCampeonato(Campeonato campeonato) {
		if (campeonato != null) {
			this.instanciaCampeonato = campeonato;
		}
		else {
			throw new RuntimeException("El campeonato recibido por parametro esta vacion. ");
		}		
	}
	public void agregarAparicionesArbitro(Club club, Arbitro arbitro) {
		
		if (club == null) {
			throw new RuntimeException("El arbitro ingresado no existe. ");
		}
		else {			
			getAsignacionArbitros().put(club, arbitro);			
		}
	}
	
	public Campeonato getInstanciaCampeonato() {
		return instanciaCampeonato;
	}
	public HashMap<Club, Arbitro> getAsignacionArbitros() {
		return cantidadAparicionesArbitros;
	}
}
