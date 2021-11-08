package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

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
		int indiceArbitros = 0;
		
		
		for (Fecha unaFecha : fechasDisponibles) {	
			todosLosArbitros = ordenarArbitros(todosLosArbitros);
			
			for (Partido partidoActual : unaFecha.getPartidos()) {
				if (indiceArbitros < todosLosArbitros.size()) {						
					revisarClubConArbitro(ret, partidoActual);						
					ret.agregarArbitroSolucion(todosLosArbitros.get(indiceArbitros));
					todosLosArbitros.get(indiceArbitros)
					.setAparicion(todosLosArbitros.get(indiceArbitros).getAparicion()+1);
					cantidadAparicionesArbitros.put(partidoActual.getEncuentro()[0], todosLosArbitros.get(indiceArbitros));
					indiceArbitros++;
				}
				
				else {
					indiceArbitros = 0;				
					revisarClubConArbitro(ret, partidoActual);						
					ret.agregarArbitroSolucion(todosLosArbitros.get(indiceArbitros));
					todosLosArbitros.get(indiceArbitros)
					.setAparicion(todosLosArbitros.get(indiceArbitros).getAparicion()+1);
					cantidadAparicionesArbitros.put(partidoActual.getEncuentro()[0], todosLosArbitros.get(indiceArbitros));
					indiceArbitros++;
				}
			}
		}
		return ret;
	}

	private void revisarClubConArbitro(Solucion ret, Partido partidoActual) {
		if(cantidadAparicionesArbitros.containsKey(partidoActual.getEncuentro()[0])){
			ret.agregarAparicionesClub(partidoActual.getEncuentro()[0]);
		}
		if(cantidadAparicionesArbitros.containsKey(partidoActual.getEncuentro()[1])){
			ret.agregarAparicionesClub(partidoActual.getEncuentro()[1]);
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
