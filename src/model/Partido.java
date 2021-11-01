package model;

public class Partido {
	
	private Club[] encuentro;
	private Arbitro arbitro;
	
	public Partido(Club uno, Club dos) {
		encuentro = new Club[1];
		encuentro[0] = uno;
		encuentro[1] = dos;
	}
	
	public Club getClub(int indice) throws Exception {
		if (indice == 0 || indice == 1) {
			return getEncuentro()[indice];
		}
		else {
			throw new RuntimeException("El indice ingresado para club, es invalido. ");
		}
	}

	public Club[] getEncuentro() {
		return this.encuentro;
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
