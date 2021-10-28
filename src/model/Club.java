package model;

import java.util.HashMap;

public class Club {
	
	String nombre;
	HashMap<Arbitro, Integer> arbitros;
	
	public Club(String nombre){
		this.nombre = nombre;
		arbitros = new HashMap<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		// TODO Auto-generated method stub
		return arbitros.containsKey(nuevo.getNombreDeArbitro());
	}
	
	
}
