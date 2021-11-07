package presenter;

import javax.swing.JLabel;

import model.Fecha;

public interface Contract {

	interface View{
		
	}
	
	interface Presenter{
		public int dameCantidadFechas();
		public int dameCantidadDePartidos(int fechaNumero);
		
	}
	
	interface model{
		public int cantidadDeFechas();
		public int cantidadDePartidos(int deFecha);
		public Fecha dameFecha(int fechaNumero);
		
	}
}
