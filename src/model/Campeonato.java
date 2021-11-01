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
			throw new RuntimeException("No hay fechas cargadas. ");
		}		
	}
	
	public boolean agregarFechas(Fecha nuevaFecha) {
		return getFechas().add(nuevaFecha);
	}
	
	public boolean existeFecha(Fecha otraFecha) {
		return getFechas().contains(otraFecha);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Arbitro> getArbitrosDisponibles() {
		if (this.arbitrosDisponibles != null) {
			return (ArrayList<Arbitro>) arbitrosDisponibles.clone();
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
	
}
