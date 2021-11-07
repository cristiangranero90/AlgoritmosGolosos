package presenter;

import model.Fecha;

public interface Contract {

	interface View{
		public int dameCantidadFechas();
		public int dameCantidadDePartidos(int fechaNumero);
		public String pedirNombrePartidos(int fechaNumero, int partidoNumero);
		
	}
	
	interface Presenter{
		public int dameCantidadFechas();
		public int dameCantidadDePartidos(int fechaNumero);
		public String damePartido(int fechaNumero, int partidoNumero);
		
	}
	
	interface model{
		public int cantidadDeFechas();
		public int cantidadDePartidos(int deFecha);
		public Fecha dameFecha(int fechaNumero);
		
	}
}
