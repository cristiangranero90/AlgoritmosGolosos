package model;

import java.util.ArrayList;

public class Campeonato {
	
	private ArrayList<Fecha> fechas;
	private ArrayList<Arbitro> arbitrosDisponibles;

	public Campeonato() {
		fechas = new ArrayList<>();
		arbitrosDisponibles = new ArrayList<>();
	}

	
	@SuppressWarnings("unchecked")
	public ArrayList<Fecha> getFechas() {
		if (this.fechas != null) {
			return (ArrayList<Fecha>) fechas.clone();
		}
		else {
			throw new RuntimeException("No existen fechas o no hay fechas cargadas. ");
		}		
	}
	
}
