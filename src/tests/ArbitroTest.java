package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Arbitro;
import model.Club;

@SuppressWarnings("unused")
public class ArbitroTest {
	
	@Test (expected=RuntimeException.class)
	public void crearArbitroNumNegativo () {
		Arbitro arbitro=new Arbitro(-1);
	}
	
	@Test (expected=RuntimeException.class)
	public void crearArbitroNombreNull () {
		Arbitro arbitro=new Arbitro(1,null);
	}
	
	@Test
	public void existeClubTest() {
		Arbitro arbitro=new Arbitro(1);
		Club boca=new Club("Boca");
		arbitro.agregarApariciones(boca);
		assertTrue (arbitro.getAparicionesPorClub().containsKey(boca));
	}

	@Test
	public void agregarAparacionTest() {
		Arbitro arbitro=new Arbitro (1);
		Club boca=new Club("Boca");
		arbitro.agregarApariciones(boca);
		arbitro.agregarApariciones(boca);
		int i=arbitro.getAparicionesPorClub().get(boca);
		assertEquals(2,i);
	}
	
	

}
