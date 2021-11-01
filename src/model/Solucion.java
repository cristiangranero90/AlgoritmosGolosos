package model;

public class Solucion {

	Arbitro arbitroSeleccionado;
	
	public Solucion(Arbitro arbitro) {
		setArbitroSeleccionado(arbitro);
	}

	public Arbitro getArbitroSeleccionado() {
		return arbitroSeleccionado;
	}

	public void setArbitroSeleccionado(Arbitro arbitro) {
		if (arbitro != null) {
			this.arbitroSeleccionado = arbitro;
		}
		else {
			throw new RuntimeException("El arbitro ingresado no existe. ");
		}
	}	
	
}
