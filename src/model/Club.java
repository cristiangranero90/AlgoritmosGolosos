package model;

import java.util.HashMap;

public class Club {	
	
	private String nombre;
	private HashMap<Arbitro, Integer> arbitros;
	
	public Club(String nombre){
		if(nombre==null)
			throw new RuntimeException ("ingresar un nombre valido");
		setNombre(nombre);
		arbitros = new HashMap<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre != null) {
			this.nombre = nombre;
		}
		else {
			throw new RuntimeException("No se ha ingresado un nombre. ");
		}		
	}
	
	public HashMap<Arbitro, Integer> getArbitros() {
		return arbitros;
	}

	public void setArbitros(HashMap<Arbitro, Integer> arbitros) {
		this.arbitros = arbitros;
	}

	public void agregarArbitro(Arbitro nuevo) {
		if (!existeArbitro(nuevo)) {
			arbitros.put(nuevo, 1);
		}
		else {
			arbitros.replace(nuevo, arbitros.get(nuevo) + 1);
		}
	}

	private boolean existeArbitro(Arbitro nuevo) {
		
		return arbitros.containsKey(nuevo);
	}
	
	public int dameCantidadApariciones (Arbitro _arbitro) {
		return arbitros.get(_arbitro).intValue();
	}
	
	@Override
	public String toString() {
		return nombre ;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {		
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Club other = (Club) obj;
		return this.nombre.equals(other.nombre);
	}
	
	
	

	
}
