package model;

import java.util.ArrayList;

public class Solucion {

	private ArrayList<Arbitro> arbitrosSeleccionados;
	
	public Solucion() {
		arbitrosSeleccionados = new ArrayList<>();
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
	
}
