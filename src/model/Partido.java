package model;

public class Partido {
	
	private Club[] encuentro;
	private Integer numeroDeFecha;
	private Arbitro arbitro;
	
	public Partido(int partido, Arbitro arbitroSeleccionado) {
		encuentro = new Club[1];
		numeroDeFecha = partido;
		arbitro = arbitroSeleccionado;
	}

	public Club[] getEncuentro() {
		return encuentro;
	}

	public void setEncuentro(Club[] encuentro) {
		this.encuentro = encuentro;
	}

	public Integer getNumeroDeFecha() {
		return numeroDeFecha;
	}

	public void setNumeroDeFecha(Integer numeroDeFecha) {
		this.numeroDeFecha = numeroDeFecha;
	}

	public Arbitro getArbitro() {
		return arbitro;
	}

	public void setArbitro(Arbitro arbitro) {
		this.arbitro = arbitro;
	}
	
}
