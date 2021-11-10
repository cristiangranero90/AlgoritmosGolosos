package model;

import java.util.HashMap;
import java.util.Random;

public class Arbitro {

	

	private Integer numeroDeArbitro;
	private String nombreDeArbitro;	
	private HashMap<Club, Integer> aparicionesPorClub;
	private int aparicion;
	private int premios;
	
	public Arbitro(int arbitroNumero, String nombre) {
		if(arbitroNumero<1 || nombre==null)
			throw new RuntimeException ("Numero de arbitro deber ser positivo y nombre no debe ser vacio");
		numeroDeArbitro = arbitroNumero;
		nombreDeArbitro = nombre;
		aparicion = 0;
		aparicionesPorClub = new HashMap<>();	
		premios = dameCondecoracionRandom();
	}
	
	public Arbitro(int arbitroNumero) {
		if(arbitroNumero<1)
			throw new RuntimeException ("el numero de arbitro debe ser mayor a 0");
		numeroDeArbitro = arbitroNumero;
		nombreDeArbitro = "";
		aparicion = 0;
		aparicionesPorClub = new HashMap<>();
		premios = dameCondecoracionRandom();
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
		return ran.nextInt(50);
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

	public int getPremios() {
		return premios;
	}

	public void setPremios(int condecoracion) {
		this.premios = getPremios() + condecoracion;
	}

	public HashMap<Club, Integer> getAparicionesPorClub() {
		return aparicionesPorClub;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroDeArbitro == null) ? 0 : numeroDeArbitro.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arbitro other = (Arbitro) obj;
		if (numeroDeArbitro == null) {
			if (other.numeroDeArbitro != null)
				return false;
		} else if (!numeroDeArbitro.equals(other.numeroDeArbitro))
			return false;
		return true;
	}
	
	
	
	
}
