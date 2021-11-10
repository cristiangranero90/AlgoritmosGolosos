package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import presenter.Contract;

public class Campeonato implements Contract.model {
	
	@SuppressWarnings("unused")
	private Contract.Presenter presentador;
	private ArrayList<Fecha> fechas;
	private ArrayList<Arbitro> arbitrosDisponibles;
	private ArrayList<String> nombresDisponibles;
	private HashMap<Club, Integer> aparicionesPorClub;

	public Campeonato(Contract.Presenter presenter) {
		
		this.fechas = new ArrayList<>();
		this.arbitrosDisponibles = new ArrayList<>();
		this.presentador = presenter;
		nombresDisponibles = new ArrayList<>();
		aparicionesPorClub = new HashMap<>();
		
	}
	
	public Campeonato() {
		this.fechas = new ArrayList<>();
		this.arbitrosDisponibles = new ArrayList<>();
		nombresDisponibles = new ArrayList<String>();
		aparicionesPorClub = new HashMap<>();
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
		aparicionesPorClub = solucionGenerada.getAparicionesClub();
	}	
	
	@Override
	public double[] dameEstadisticaArbitros() {
		return generarEstadistica();
	}
	
	@Override
	public String[] dameNombresDeClub() {
		return generarNombres();
	}
	
	private String[] generarNombres() {
		String[] ret = new String[aparicionesPorClub.size()];
		if(aparicionesPorClub.size() > 0) {
			Iterator<Club> ite = aparicionesPorClub.keySet().iterator();
			int indice = 0;
			while(ite.hasNext()) {
				String nombre = ite.next().getNombre();
				ret[indice] = nombre;
				indice++;
			}
			return ret;
		}
		else {
			throw new RuntimeException("No existen clubs creados actualmente. ");
		}
	}
	
	public double[] generarEstadistica() {
		if (aparicionesPorClub.size() > 0) {
			Iterator<Integer> ite = aparicionesPorClub.values().iterator();		
			double[] conjunto = new double[aparicionesPorClub.values().size()];
			double total = 0.0;
			int indice = 0;
			while(ite.hasNext()) {
				Integer aux = ite.next();
				total = total + (double) aux;
				conjunto[indice] = (double) aux;				
				indice++;
			}			
			for (int i = 0; i < conjunto.length ; i++) {
				conjunto[i] = ((conjunto[i] / total) * 100.0);
			}
			return conjunto;
		}
		else {
			throw new RuntimeException("No se pudo generar una estadistica. ");
		}
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
		validarFecha(nuevaFecha);
		return getFechas().add(nuevaFecha);
	}
	
	public boolean existeFecha(Fecha otraFecha) {
		validarFecha(otraFecha);
			
		return getFechas().contains(otraFecha);
	}
	
	private void validarFecha(Fecha otraFecha) {
		if(otraFecha==null) {
			throw new RuntimeException("fecha no valida");
		}
		
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

	public boolean existeArbitro(Arbitro nuevo) {
		if(nuevo==null)
			throw new RuntimeException("el arbitro no es valido");
		return arbitrosDisponibles.contains(nuevo);
	}
	
	public int cantFechas() {
		return this.fechas.size();
	}
	
	@Override
	public int cantidadDeFechas() {
		return cantFechas();
	}

	@Override
	public int cantidadDePartidos(int deFecha) {	
		controlFechas(deFecha);
		return getFechas().get(deFecha).cantidadPartidos();
	}

	@Override
	public Fecha dameFecha(int fechaNumero) {
		controlFechas(fechaNumero);
		return getFechas().get(fechaNumero);
	}

	@Override
	public boolean arbitrosAsignados() {	
		return getFechas().get(0).existenArbitros();
	}


	@Override
	public void generarArbitros(boolean nombres, int cantidad) {
		if (!nombres) {
			for (int i = 1; i < cantidad; i++) {
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
	
	private void controlFechas(int fecha) {
		if(fecha<0) {
			throw new RuntimeException ("numero de fecha no puede ser menor a 0");
		}
			
	}

	@Override
	public String toString() {
		return "Campeonato [fechas " + fechas + "]";
	}
	
}
