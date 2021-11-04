package model;

import java.util.HashMap;
import java.util.Map;

public class Partido {
	
	private Map<Club,Club> encuentro;
	private Arbitro arbitro;
	
	public Partido(Club uno, Club dos) {
		encuentro = new HashMap <Club,Club>();
		encuentro.put(uno, dos);
	}
	
	//public Club getClub(int indice) throws Exception {
		//if (indice == 0 || indice == 1) {
			//return getEncuentro()[indice];
		//}
		//else {
		//	throw new RuntimeException("El indice ingresado para club, es invalido. ");
	//	}
	//}

	public HashMap getEncuentro() {
		return (HashMap) encuentro;
	}
	
	@Override
	public String toString() {
		return encuentro.toString();
	}

	public void setArbitro(Arbitro nuevo) {
		if (arbitro != null) {
			this.arbitro = nuevo;
		}
		else {
			throw new RuntimeException("El arbitro ingresado es invalido. ");
		}
	}

	public Arbitro getArbitro() {
		return this.arbitro;
	}	
}
