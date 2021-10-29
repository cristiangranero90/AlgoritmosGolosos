package model;

import java.util.ArrayList;

public class Fecha {
	
	private ArrayList<Partido> partidos;
	private Integer numeroDeFecha;
	
	public Fecha(int numeroDePartido) {
		partidos = new ArrayList<>();
		setNumeroDeFecha(numeroDePartido);
	}

	public ArrayList<Partido> getPartidos() {
		return partidos;
	}

	public Integer getNumeroDeFecha() {
		return numeroDeFecha;
	}

	public void setNumeroDeFecha(int numeroDeFecha) {
		if (numeroDeFecha > 0) {
			this.numeroDeFecha = numeroDeFecha;
		}
		else {
			throw new RuntimeException("Numero de partido invalido. ");
		}
		
		
	}
	

}
