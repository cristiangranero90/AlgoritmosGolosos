package model;

import java.util.HashMap;

public class Solver {
	
	private Campeonato instanciaCampeonato;
	private HashMap<Arbitro, Integer> asignacionArbitros;
	
	Solver(Campeonato campeonato){
		setInstanciaCampeonato(campeonato);
	}

	public void setInstanciaCampeonato(Campeonato campeonato) {
		if (campeonato != null) {
			this.instanciaCampeonato = campeonato;
		}
		else {
			throw new RuntimeException("El campeonato recibido por parametro esta vacion. ");
		}		
	}
	
	
	
}
