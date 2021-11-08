package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Solucion {

	private ArrayList<Arbitro> arbitrosSeleccionados;
	private HashMap<Club, Integer> cantidadAparicionesClub;
	
	public Solucion() {
		arbitrosSeleccionados = new ArrayList<>();
		cantidadAparicionesClub = new HashMap<>();
	}
	
	public void agregarArbitroSolucion(Arbitro nuevoarbitro) {
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
	public int tamanoAparicionesArbitro() {
		return cantidadAparicionesClub.size();
	}
	
}
