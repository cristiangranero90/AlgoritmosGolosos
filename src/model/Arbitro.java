package model;

public class Arbitro {

	private Integer numeroDeArbitro;
	private String nombreDeArbitro;
	private int aparicion;
	
	public Arbitro(int arbitroNumero, String nombre) {
		numeroDeArbitro = arbitroNumero;
		nombreDeArbitro = nombre;
		aparicion = 0;
	}
	public Arbitro(int arbitroNumero) {
		numeroDeArbitro = arbitroNumero;
		nombreDeArbitro = "";
		aparicion = 0;
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
