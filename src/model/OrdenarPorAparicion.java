package model;

public class OrdenarPorAparicion extends Ordenar{

	@Override
	public int compare(Arbitro uno, Arbitro otro) {
		return uno.getAparicion() - otro.getAparicion(); 
	}	
}
