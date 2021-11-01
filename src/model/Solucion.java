package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Solucion {

	private Campeonato instanciaCampeonato;
	private HashMap<Arbitro, Integer> asignacionArbitros;
	
	Solucion(Campeonato campeonato){
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
