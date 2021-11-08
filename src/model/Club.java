package model;

import java.util.HashMap;

public class Club {	
	
	private String nombre;
	private HashMap<Arbitro, Integer> arbitros;
	
	public Club(String nombre){
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

	
}
