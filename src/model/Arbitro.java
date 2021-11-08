package model;

import java.util.HashMap;
import java.util.Random;

public class Arbitro {

	private Integer numeroDeArbitro;
	private String nombreDeArbitro;	
	private HashMap<Club, Integer> aparicionesPorClub;
	private int aparicion;
	private int condecoracion;
	
	public Arbitro(int arbitroNumero, String nombre) {
		numeroDeArbitro = arbitroNumero;
		nombreDeArbitro = nombre;
		aparicion = 0;
		aparicionesPorClub = new HashMap<>();	
		condecoracion = dameCondecoracionRandom();
	}
	
	public Arbitro(int arbitroNumero) {
		numeroDeArbitro = arbitroNumero;
		nombreDeArbitro = "";
		aparicion = 0;
		aparicionesPorClub = new HashMap<>();
		condecoracion = dameCondecoracionRandom();
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

	private int dameCondecoracionRandom() {
		Random ran = new Random();
		return ran.nextInt(1, 50);
	}

	public Integer getNumeroDeArbitro() {
		return numeroDeArbitro + 1;
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

	public int getCondecoracion() {
		return condecoracion;
	}

	public void setCondecoracion(int condecoracion) {
		this.condecoracion = getCondecoracion() + condecoracion;
	}

	public HashMap<Club, Integer> getAparicionesPorClub() {
		return aparicionesPorClub;
	}
	
	
	
	
}
