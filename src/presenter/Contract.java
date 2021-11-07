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
		
	}
	
	interface Presenter{
		public int dameCantidadFechas();
		public int dameCantidadDePartidos(int fechaNumero);
		public String damePartido(int fechaNumero, int partidoNumero);
		public boolean arbitrosAsignados();
		
	}
	
	interface model{
		public int cantidadDeFechas();
		public int cantidadDePartidos(int deFecha);
		public Fecha dameFecha(int fechaNumero);
		public boolean arbitrosAsignados();
		public void registrarSolucion(Solucion solucion);
		
	}
}
