package model;

import java.util.ArrayList;

import presenter.Contract;

public class Campeonato implements Contract.model {
	
	private Contract.Presenter presentador;
	private ArrayList<Fecha> fechas;
	private ArrayList<Arbitro> arbitrosDisponibles;
	private ArrayList<String> nombresDisponibles;

	public Campeonato(Contract.Presenter presenter) {
		
		this.fechas = new ArrayList<>();
		this.arbitrosDisponibles = new ArrayList<>();
		this.presentador = presenter;
		nombresDisponibles = new ArrayList<>();
	}
	
	public Campeonato() {
		this.fechas = new ArrayList<>();
		this.arbitrosDisponibles = new ArrayList<>();
		nombresDisponibles = new ArrayList<String>();
	}
	
	@Override
	public void asignarSolucion(Solucion solucionGenerada) {
		int indice = 0;
		for(Fecha fecha : getFechas()) {			
			for (Partido partidoActual : fecha.getPartidos()) {
				partidoActual.setArbitro(solucionGenerada.dameArbitro(indice));
				indice++;
			}
		}
	}	
	
	@Override
	public double[] dameEstadisticaArbitros() {
		double[] ret = new double[getCantidadArbitros()];
		double total = 0.0;
		int indice = 0;
		for (Arbitro arbitro : getArbitrosDisponibles()) {
			ret[indice] = (double) arbitro.getAparicion();
			total += (double) arbitro.getAparicion();
			indice++;
		}
		for (int i = 0; i < ret.length; i++) {
			ret[i] = ((ret[i] / total) * 100.0) * 100.0;
		}		
		return ret;
	}
	
	public int getCantidadArbitros() {
		return getArbitrosDisponibles().size();
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

	@Override
	public boolean arbitrosAsignados() {	
		return getFechas().get(0).existenArbitros();
	}


	@Override
	public void generarArbitros(boolean nombres, int cantidad) {
		if (!nombres) {
			for (int i = 0; i < cantidad; i++) {
				Arbitro nuevo = new Arbitro(i, "Sin nombre");
				arbitrosDisponibles.add(nuevo);
			}	
		}
		else {
			arbitrosDisponibles = new ArrayList<>();
			nombresDisponibles = data.PartidosPersistentes.leerNombres();
			for (int i = 0; i < cantidad; i++) {
				Arbitro nuevo = new Arbitro(i, nombresDisponibles.get(i));
				arbitrosDisponibles.add(nuevo);
			}
		}
			
	}
	
}
