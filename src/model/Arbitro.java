package model;

public class Arbitro {

	Integer numeroDeArbitro;
	String nombreDeArbitro;
	
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
	
}
