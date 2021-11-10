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
		for(Partido part: getPartidos()) {
			if (partidoRepetido(part,nuevo.getEncuentro()[0])||partidoRepetido(part,nuevo.getEncuentro()[1]));
				throw new RuntimeException("no puede esta el mismo club dos veces en la misma fecha");	
		}
			
		
				return getPartidos().add(nuevo);
	}
	
	private boolean partidoRepetido(Partido part, Club club) {
		if (part.getEncuentro()[0].equals(club)||part.getEncuentro()[1].equals(club))
			return true;
		else
			return false;
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
	
	public boolean existenArbitros() {
		
		if (getPartidos().get(0).getArbitro() == null) {
			return false;
		}
		else {
			boolean ret = true;
			for (Partido partidos : getPartidos()) {
				ret = ret && partidos.getArbitro() != null;
			}
			return ret;
		}
	}

	
}
