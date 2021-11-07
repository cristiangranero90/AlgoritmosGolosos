package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Solver {
	
	private Campeonato instanciaCampeonato;
	private HashMap<Arbitro, Integer> cantidadAparicionesArbitros;
	private Comparator<Arbitro> estrategiaActual;
	
	public Solver(Campeonato campeonato, Comparator<Arbitro> estrategia){
		setInstanciaCampeonato(campeonato);
		cantidadAparicionesArbitros = new HashMap<Arbitro, Integer>();
		estrategiaActual = estrategia;
	}
	
	public Solucion resolver() {
		Solucion ret = new Solucion();
		ArrayList<Arbitro> todosLosArbitros = getInstanciaCampeonato().getArbitrosDisponibles();
		ArrayList<Fecha> fechasDisponibles = getInstanciaCampeonato().getFechas();
		
		for (Fecha unaFecha : fechasDisponibles) {	
			todosLosArbitros = ordenarArbitros(todosLosArbitros);
			int indiceArbitros = 0;
			for (@SuppressWarnings("unused") Partido partidoActual : unaFecha.getPartidos()) {
				if (indiceArbitros < todosLosArbitros.size()) {
					ret.agregarArbitroSolucion(todosLosArbitros.get(indiceArbitros));
					todosLosArbitros.get(indiceArbitros)
					.setAparicion(todosLosArbitros.get(indiceArbitros).getAparicion()+1);
				}
				else {
					indiceArbitros = 0;
					ret.agregarArbitroSolucion(todosLosArbitros.get(indiceArbitros));
					todosLosArbitros.get(indiceArbitros)
					.setAparicion(todosLosArbitros.get(indiceArbitros).getAparicion()+1);
				}
			}
		}
		return ret;
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
