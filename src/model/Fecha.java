package model;

import java.util.ArrayList;

public class Fecha  {
	
	private ArrayList<Partido> partidos;
	private Integer numeroDeFecha;
	
	public Fecha(int numeroDePartido) {
		partidos = new ArrayList<>();
		setNumeroDeFecha(numeroDePartido);
	}
	
	public boolean agregarPartido(Partido nuevo) {
		return getPartidos().add(nuevo);
	}
	
	public int cantidadPartidos() {
		return getPartidos().size();
	}

	public ArrayList<Partido> getPartidos() {
		return (ArrayList<Partido>) partidos;
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
