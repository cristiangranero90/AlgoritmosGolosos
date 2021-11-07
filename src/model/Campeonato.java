package model;

import java.util.ArrayList;

import presenter.Contract;

public class Campeonato implements Contract.model {
	
	private Contract.Presenter presenter;
	private ArrayList<Fecha> fechas;
	private ArrayList<Arbitro> arbitrosDisponibles;

	public Campeonato(Contract.Presenter presenter) {
		this.fechas = new ArrayList<>();
		this.arbitrosDisponibles = new ArrayList<>();
		this.presenter = presenter;
	}
	
	public Campeonato() {
		this.fechas = new ArrayList<>();
		this.arbitrosDisponibles = new ArrayList<>();
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
	
	@Override
	public String toString() {
		return "Campeonato [fechas " + fechas + "]";
	}

	@Override
	public int cantidadDeFechas() {
		return cantFechas();
	}

	@Override
	public int cantidadDePartidos(int deFecha) {		
		return getFechas().get(deFecha).cantidadPartidos();
	}

	@Override
	public Fecha dameFecha(int fechaNumero) {
		return getFechas().get(fechaNumero);
	}

	
}
