package model;

import java.util.ArrayList;

public class Solucion {

	private ArrayList<Fecha> fechas;
	
	public Solucion(ArrayList<Fecha> fechas) {
		setFechas(fechas);
	}

	public ArrayList<Fecha> getFechas() {
		return fechas;
	}

	public void setFechas(ArrayList<Fecha> fechas) {
		if (fechas != null) {
			this.fechas = fechas;
		}
		else {
			throw new RuntimeException("Error en las fechas. ");
		}
		
	}
	
	
	
	
	
}
