package model;

import java.util.HashMap;
import java.util.Map;

public class Partido {
	
	private Map<Club,Club> encuentro;
	private Arbitro arbitro;
	private Club _club1;
	private Club _club2;
	
	public Partido(Club uno, Club dos) {
		encuentro = new HashMap <Club,Club>();
		encuentro.put(uno, dos);
		_club1=uno;
		_club2=dos;
	}
	
	public Map<Club,Club> getEncuentro() {
		return encuentro;
	}
	
	public int cantidadAparicionesArbitro (Arbitro _arbitro) {
		return _club1.dameCantidadApariciones(_arbitro)+ _club2.dameCantidadApariciones(_arbitro);
		
	}
	
	@Override
	public String toString() {
		StringBuilder encuentroString = new StringBuilder();
		for (int i = 0; i < getEncuentro().toString().length(); i++) {
			if (getEncuentro().toString().charAt(i) != '{' && 
					getEncuentro().toString().charAt(i) != '}' &&
					getEncuentro().toString().charAt(i) != '=') {
				
				encuentroString.append(getEncuentro().toString().charAt(i));
			}
			
			else if (getEncuentro().toString().charAt(i) == '=') {
				encuentroString.append("  -  ");
			}			
		}
		
		if (getArbitro() == null) {
			encuentroString.append("   ->   Arbitro aun no seleccionado");
		}
		else { 
			encuentroString.append("   ->   Arbitro numero: " + 
					getArbitro().getNumeroDeArbitro() +
					"   " + getArbitro().getNombreDeArbitro());
		}		
		return encuentroString.toString().toUpperCase();
	}

	public void setArbitro(Arbitro nuevo) {
		if (nuevo != null) {
			this.arbitro = nuevo;
		}
		else {
			throw new RuntimeException("El arbitro ingresado es invalido. ");
		}
	}

	public Arbitro getArbitro() {
		return this.arbitro;
	}	
}
