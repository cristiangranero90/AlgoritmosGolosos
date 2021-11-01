package model;

public class Arbitro {

	private Integer numeroDeArbitro;
	private String nombreDeArbitro;
	private int aparicion;
	
	public Arbitro(int arbitroNumero, String nombre) {
		numeroDeArbitro = arbitroNumero;
		nombreDeArbitro = nombre;
	}
	public Arbitro() {
		numeroDeArbitro = -1;
		nombreDeArbitro = "";
	}

	public Integer getNumeroDeArbitro() {
		return numeroDeArbitro;
	}

	public void setNumeroDeArbitro(Integer numeroDeArbitro) {
		this.numeroDeArbitro = numeroDeArbitro;
	}

	public String getNombreDeArbitro() {
		return nombreDeArbitro;
	}

	public void setNombreDeArbitro(String nombreDeArbitro) {
		this.nombreDeArbitro = nombreDeArbitro;
	}
	public int getAparicion() {
		return aparicion;
	}
	public void setAparicion(int aparicion) {
		this.aparicion = aparicion;
	}
	
	
}
