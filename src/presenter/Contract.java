package presenter;

import model.Fecha;
import model.Solucion;

public interface Contract {

	interface View{
		public int dameCantidadFechas();
		public int dameCantidadDePartidos(int fechaNumero);
		public String pedirNombrePartidos(int fechaNumero, int partidoNumero);
		public boolean existenArbitros();
		public void construirGrafico();
		public void construirCalendario();
		public double[] pedirEstadisticas();
		public void crearArbitros(boolean nombres, int cantidad);
	}
	
	interface Presenter{
		public int dameCantidadFechas();
		public int dameCantidadDePartidos(int fechaNumero);
		public String damePartido(int fechaNumero, int partidoNumero);
		public boolean arbitrosAsignados();
		public double[] dameEstadistica();
		public void construirArbitros(boolean nombres, int cantidad);
		
	}
	
	interface model{
		public int cantidadDeFechas();
		public int cantidadDePartidos(int deFecha);
		public Fecha dameFecha(int fechaNumero);
		public boolean arbitrosAsignados();
		public void asignarSolucion(Solucion solucion);
		public void generarArbitros(boolean nombres, int cantidad);
		public double[] dameEstadisticaArbitros();
	}
}
