package model;

import java.util.ArrayList;
import java.util.HashMap;

import sun.util.resources.Bundles.Strategy;

public class Solver {
	
	private Campeonato instanciaCampeonato;
	private HashMap<Arbitro, HashMap<Club, Integer>> asignacionArbitros;
	private Strategy estrategiaActual;
	
	Solver(Campeonato campeonato, Strategy estrategia){
		setInstanciaCampeonato(campeonato);
		asignacionArbitros = new HashMap<Arbitro, HashMap<Club, Integer>>();
		estrategiaActual = estrategia;
	}
	
	public Solucion resolver() {
		ArrayList<Arbitro> todosLosArbitros = getInstanciaCampeonato().getArbitrosDisponibles();
		ArrayList<Fecha> fechasDisponibles = getInstanciaCampeonato().getFechas();
		
		for (Fecha unaFecha : fechasDisponibles) {
			for (Partido partidosActuales : unaFecha.getPartidos()) {
				
			}
		}
		
		return null;
	}
	
	public void setInstanciaCampeonato(Campeonato campeonato) {
		if (campeonato != null) {
			this.instanciaCampeonato = campeonato;
		}
		else {
			throw new RuntimeException("El campeonato recibido por parametro esta vacion. ");
		}		
	}
	
	public Campeonato getInstanciaCampeonato() {
		return instanciaCampeonato;
	}
	public HashMap<Arbitro, HashMap<Club, Integer>> getAsignacionArbitros() {
		return asignacionArbitros;
	}
	
	
	
	
}
