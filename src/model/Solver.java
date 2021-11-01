package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Solver {
	
	private Campeonato instanciaCampeonato;
	private HashMap<Arbitro, Integer> cantidadAparicionesArbitros;
	private Comparator<Arbitro> estrategiaActual;
	
	Solver(Campeonato campeonato, Comparator<Arbitro> estrategia){
		setInstanciaCampeonato(campeonato);
		cantidadAparicionesArbitros = new HashMap<Arbitro, Integer>();
		estrategiaActual = estrategia;
	}
	
	public void resolver() {
		//TODO null
		
		ArrayList<Arbitro> todosLosArbitros = getInstanciaCampeonato().getArbitrosDisponibles();
		//ArrayList<Arbitro> todosLosArbitros = getInstanciaCampeonato().getArbitrosDisponibles();
		ArrayList<Fecha> fechasDisponibles = getInstanciaCampeonato().getFechas();
		
		for (Fecha unaFecha : fechasDisponibles) {	
			int indiceArbitros = 0;
			todosLosArbitros = ordenarArbitros(todosLosArbitros);
			for (Partido partidoActual : unaFecha.getPartidos()) {
				partidoActual.setArbitro(todosLosArbitros.get(indiceArbitros));
				indiceArbitros++;
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
	public void agregarAparicionesArbitro(Arbitro nuevoArbitro) {
		if (nuevoArbitro == null) {
			throw new RuntimeException("El arbitro ingresado no existe. ");
		}
		else {
			if (getAsignacionArbitros().containsKey(nuevoArbitro)) {
				getAsignacionArbitros().replace(nuevoArbitro, getAsignacionArbitros().get(nuevoArbitro) + 1);
			}
			else {
				getAsignacionArbitros().put(nuevoArbitro, 1);
			}
		}
	}
	
	public Campeonato getInstanciaCampeonato() {
		return instanciaCampeonato;
	}
	public HashMap<Arbitro, Integer> getAsignacionArbitros() {
		return cantidadAparicionesArbitros;
	}
	
	
	
	
}
