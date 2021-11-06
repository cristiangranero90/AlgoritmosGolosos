package presenter;

import model.Campeonato;
import presenter.Contract.View;

public class Presenter implements Contract.Presenter {

	private Contract.model model;
	private Contract.View view;
	
	public Presenter(Contract.View view) {
		this.view = view;
		model = new Campeonato(this);
		
	}
}
