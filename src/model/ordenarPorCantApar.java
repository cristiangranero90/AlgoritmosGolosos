package model;

import java.util.Comparator;

public class ordenarPorCantApar implements Comparator<Arbitro>{
	
	
	@Override
	public int compare(Arbitro uno, Arbitro otro) {
		// TODO Auto-generated method stub
		return  -uno.getNumeroDeArbitro()+ otro.getNumeroDeArbitro();
	}
	



}
