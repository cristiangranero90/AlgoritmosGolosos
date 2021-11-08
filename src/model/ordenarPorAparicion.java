package model;

public class ordenarPorAparicion extends Ordenar{

	@Override
	public int compare(Arbitro uno, Arbitro otro) {
		// TODO Auto-generated method stub
		return -uno.getAparicion() + otro.getAparicion();
	}	

}
