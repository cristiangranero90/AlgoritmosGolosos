package model;

import java.util.ArrayList;

public class Campeonato {
	
	@Override
	public String toString() {
		return "Campeonato [fechas " + fechas + "]";
	}

	private ArrayList<Fecha> fechas;
	private ArrayList<Arbitro> arbitrosDisponibles;

	public Campeonato() {
		fechas = new ArrayList<>();
		arbitrosDisponibles = new ArrayList<>();
	}
	
	public void asignarSolucion(Solucion solucionGenerada) {
		int indice = 0;
		for(Fecha fecha : getFechas()) {
			for (Partido partidoActual : fecha.getPartidos()) {
				partidoActual.setArbitro(solucionGenerada.getArbitrosSeleccionados().get(indice));
			}
		}
	}	
	
	public ArrayList<Fecha> getFechas() {
		if (this.fechas != null) {
			return (ArrayList<Fecha>) fechas;
		}
		else {
			throw new RuntimeException("No hay fechas cargadas. ");
		}		
	}
	
	public boolean agregarFechas(Fecha nuevaFecha) {
		return getFechas().add(nuevaFecha);
	}
	
	public boolean existeFecha(Fecha otraFecha) {
		return getFechas().contains(otraFecha);
	}
	
	public ArrayList<Arbitro> getArbitrosDisponibles() {
		if (this.arbitrosDisponibles != null) {
			return (ArrayList<Arbitro>) arbitrosDisponibles;
		}
		else {
			throw new RuntimeException("No existe arbitro o no hay arbitros cargados. ");
		}		
	}
	
	public boolean agregarArbitro(Arbitro nuevo) {
		if (!existeArbitro(nuevo)) {
			return getArbitrosDisponibles().add(nuevo);
		}
		return false;
	}

	private boolean existeArbitro(Arbitro nuevo) {		
		return arbitrosDisponibles.contains(nuevo);
	}
	
	public int cantFechas() {
		return this.fechas.size();
	}
	
}
