package model;

public class ordenarPorAparicion extends Ordenar{

	@Override
	public int compare(Arbitro uno, Arbitro otro) {
		return uno.getAparicion() - otro.getAparicion(); 
	}	
}
