package presenter;

import model.Fecha;

public interface Contract {

	interface View{
		public int dameCantidadFechas();
		public int dameCantidadDePartidos(int fechaNumero);
		public String pedirNombrePartidos(int fechaNumero, int partidoNumero);
		public boolean existenArbitros();
		
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
		
	}
}
