package model;

import java.util.Comparator;

public class ordenarPorCantApar extends Ordenar{

	@Override
	public int compare(Arbitro uno, Arbitro otro) {		
		return  -uno.getNumeroDeArbitro()+ otro.getNumeroDeArbitro();
	}
}
