package presenter;

import data.PartidosPersistentes;
import model.Campeonato;
import presenter.Contract.View;

public class Presenter implements Contract.Presenter {

	private Contract.model model;
	private Contract.View view;
	
	public Presenter(Contract.View view) {
		this.view = view;
		model = PartidosPersistentes.Lectura(this);		
	}

	@Override
	public int dameCantidadFechas() {
		return model.cantidadDeFechas();
	}

	public int dameCantidadDePartidos(int i) {
		// TODO Auto-generated method stub
		return model.cantidadDePartidos(i);
	}

	public String damePartido(int fechaNumero, int partidoNumero) {
		
		return model.dameFecha(fechaNumero).nombrePartido(partidoNumero);
	}
}
