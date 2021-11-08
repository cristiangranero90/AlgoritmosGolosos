package model;

public class ordenarPorCantApar extends Ordenar{

	@Override
	public int compare(Arbitro uno, Arbitro otro) {		
		return  -uno.getNumeroDeArbitro()+ otro.getNumeroDeArbitro();
	}
}
