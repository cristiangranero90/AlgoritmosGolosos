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
}
