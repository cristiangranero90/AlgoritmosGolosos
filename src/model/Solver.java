package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Solver {
	
	private Campeonato instanciaCampeonato;
	private HashMap<Arbitro, HashMap<Club, Integer>> asignacionArbitros;
	
	Solver(Campeonato campeonato){
		setInstanciaCampeonato(campeonato);
		asignacionArbitros = new HashMap<Arbitro, HashMap<Club, Integer>>();
	}
	
	public Solucion resolver() {
		ArrayList<Arbitro> todosLosArbitros = getInstanciaCampeonato().getArbitrosDisponibles();
		
		
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
