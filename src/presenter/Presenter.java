package presenter;

import data.PartidosPersistentes;
import model.Campeonato;
import model.Ordenar;
import model.Solucion;
import model.Solver;
import model.OrdenarPorAparicion;
import model.OrdenarPorPremiacion;

public class Presenter implements Contract.Presenter {

	private Contract.model model;
	private Contract.View view;
	
	public Presenter(Contract.View view) {
		this.view = view;
		model = PartidosPersistentes.Lectura(this);	
		model.generarArbitros(false, 10);		
	}

	@Override
	public int dameCantidadFechas() {
		return model.cantidadDeFechas();		
	}

	@Override
	public int dameCantidadDePartidos(int i) {
		return model.cantidadDePartidos(i);
	}

	@Override
	public String damePartido(int fechaNumero, int partidoNumero) {		
		return model.dameFecha(fechaNumero).nombrePartido(partidoNumero);
	}

	@Override
	public boolean arbitrosAsignados() {		
		return model.arbitrosAsignados();
	}

	public void botonAplicar(String selectedItem) {
		
		switch (selectedItem) {
			
			case "Heuristica por apariciones" : generarSolucion(new OrdenarPorAparicion());
			break;
			
			case "Heuristica por premiacion" : generarSolucion(new OrdenarPorPremiacion());
			break;
			
			default : throw new RuntimeException("Elemento invalido. ");		
		}		
	}

	private void generarSolucion(Ordenar criterio) {		
		//Thread generarSolucion
		Runnable generar = new Runnable() {
			@Override
			public void run() {
				Solver solver = new Solver((Campeonato) model, criterio);
				Solucion solucion = solver.resolver();
				model.asignarSolucion(solucion);
				view.construirGrafico();
				view.construirCalendario();				
			}
		};
		generar.run();			
	}

	@Override
	public double[] dameEstadistica() {
		return model.dameEstadisticaArbitros();
	}

	@Override
	public void construirArbitros(boolean nombres, int cantidad) {
		model.generarArbitros(nombres, cantidad);		
	}

	@Override
	public String[] dameClubs() {
		return model.dameNombresDeClub();
	}
}
