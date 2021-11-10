package model;

public class Partido {
	
	private Club[] encuentro;
	private Arbitro arbitro;
	private Club _club1;
	private Club _club2;
	
	public Partido(Club uno, Club dos) {
		encuentro = new Club[2];
		encuentro[0] = uno;
		encuentro[1] = dos;
		_club1=uno;
		_club2=dos;
	}
	
	public Club[] getEncuentro() {
		return encuentro;
	}
	
	public int cantidadAparicionesArbitro (Arbitro _arbitro) {
		return _club1.dameCantidadApariciones(_arbitro)+ _club2.dameCantidadApariciones(_arbitro);
		
	}
	
	@Override
	public String toString() {
		StringBuilder encuentroString = new StringBuilder();
		for (int i = 0; i < getEncuentro().length; i++) {
			
			encuentroString.append(getEncuentro()[i].toString().toUpperCase() + "    ");
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
	
	public boolean existeClubEnPartido (Club club) {
		if (encuentro[0].equals(club)||encuentro[1].equals(club))
			return true;
		else
			return false;
	}

	public Arbitro getArbitro() {
		return this.arbitro;
	}	
}
