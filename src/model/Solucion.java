package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Solucion {

	private ArrayList<Arbitro> arbitrosSeleccionados;
	private HashMap<Club, Integer> cantidadAparicionesClub;
	private int arbitrosTotal;
	
	public Solucion() {
		arbitrosSeleccionados = new ArrayList<>();
		cantidadAparicionesClub = new HashMap<>();
		this.arbitrosTotal = 0;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arbitrosSeleccionados == null) ? 0 : arbitrosSeleccionados.hashCode());
		result = prime * result + ((cantidadAparicionesClub == null) ? 0 : cantidadAparicionesClub.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Solucion other = (Solucion) obj;
		if (arbitrosSeleccionados == null) {
			if (other.arbitrosSeleccionados != null)
				return false;
		} else if (!arbitrosSeleccionados.equals(other.arbitrosSeleccionados))
			return false;
		if (cantidadAparicionesClub == null) {
			if (other.cantidadAparicionesClub != null)
				return false;
		} else if (!cantidadAparicionesClub.equals(other.cantidadAparicionesClub))
			return false;
		return true;
	}

	public void agregarArbitroSolucion(Arbitro nuevoarbitro) {
		if (nuevoarbitro==null)
			throw new RuntimeException ("El arbitro ingresado debe ser distinto de null");
		getArbitrosSeleccionados().add(nuevoarbitro);
	}
	
	public Arbitro dameArbitro(int indice) {
		if (indice < arbitrosSeleccionados.size()) {
			return arbitrosSeleccionados.get(indice);
		}
		else {
			throw new RuntimeException("El indice ingresado es invalido. ");
		}
	}

	public ArrayList<Arbitro> getArbitrosSeleccionados() {
		return arbitrosSeleccionados;
	}

	public void setArbitroSeleccionado(ArrayList<Arbitro> arbitros) {
		if (arbitros != null) {
			this.arbitrosSeleccionados = arbitros;
		}
		else {
			throw new RuntimeException("Los arbitros ingresados no existen. ");
		}
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<Club, Integer> getAparicionesClub(){
		return (HashMap<Club, Integer>) cantidadAparicionesClub.clone();
	}
	
	public void agregarAparicionesClub(Club club) {
		
		if (cantidadAparicionesClub.containsKey(club)) {
			cantidadAparicionesClub.replace(club, cantidadAparicionesClub.get(club) + 1);
		}
		else {
			cantidadAparicionesClub.put(club, 1);
		}
	}
	
public void agregarAparicionesClub(Club club, Integer valor) {			
		cantidadAparicionesClub.put(club, valor);		
	}
	
	
	
	public int tamanoAparicionesArbitro() {
		return cantidadAparicionesClub.size();
	}

	public int getArbitrosTotal() {
		return arbitrosTotal;
	}

	public void setArbitrosTotal(int arbitrosTotal) {
		this.arbitrosTotal = arbitrosTotal;
	}
	
	
	
}
