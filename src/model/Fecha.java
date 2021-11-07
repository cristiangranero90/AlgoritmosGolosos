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
	
	public Partido damePartido(int i) {
		if (i > cantidadPartidos() || i < 0 ) {
			throw new RuntimeException("Indice de partido invalido");
		}
		return getPartidos().get(i);
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
	
	public String nombrePartido(int partidoNumero) {
		return getPartidos().get(partidoNumero).toString();
	}
	
	@Override
	public String toString() {
		return "  numero De Fecha  " + numeroDeFecha +"  partidos = " + partidos ;
	}

	
}
