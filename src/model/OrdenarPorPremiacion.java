package model;

public class OrdenarPorPremiacion extends Ordenar{

	@Override
	public int compare(Arbitro uno, Arbitro otro) {	
		return uno.getPremios() - otro.getPremios();
	}
}
