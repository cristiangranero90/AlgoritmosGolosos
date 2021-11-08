package model;

import java.util.HashMap;

public class Arbitro {

	private Integer numeroDeArbitro;
	private String nombreDeArbitro;	
	private HashMap<Club, Integer> aparicionesPorClub;
	private int aparicion;
	
	public Arbitro(int arbitroNumero, String nombre) {
		numeroDeArbitro = arbitroNumero;
		nombreDeArbitro = nombre;
		aparicion = 0;
		aparicionesPorClub = new HashMap<>();		
	}
	
	public Arbitro(int arbitroNumero) {
		numeroDeArbitro = arbitroNumero;
		nombreDeArbitro = "";
		aparicion = 0;
		aparicionesPorClub = new HashMap<>();
	}
	
	public boolean existeClub(Club club) {
		return aparicionesPorClub.containsKey(club);
	}
	
	public void agregarApariciones(Club club) {
		if (aparicionesPorClub.containsKey(club)) {
			aparicionesPorClub.replace(club, aparicionesPorClub.get(club) + 1);
		}
		else {
			aparicionesPorClub.put(club, 1);
		}		
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
