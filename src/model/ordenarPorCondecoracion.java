package model;

public class ordenarPorCondecoracion extends Ordenar{

	@Override
	public int compare(Arbitro uno, Arbitro otro) {	
		return uno.getPremios() - otro.getPremios();
	}
}
