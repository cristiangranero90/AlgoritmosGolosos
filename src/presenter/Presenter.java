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
}
