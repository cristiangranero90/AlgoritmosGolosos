package model;

public class Partido {
	
	private Club[] encuentro;
	private Arbitro arbitro;
	
	public Partido(Arbitro arbitroSeleccionado) {
		encuentro = new Club[1];
		arbitro = arbitroSeleccionado;
	}

	public Club[] getEncuentro() {
		return encuentro;
	}

	public void setEncuentro(Club[] encuentro) {
		this.encuentro = encuentro;
	}

	public Arbitro getArbitro() {
		return arbitro;
	}	
}
