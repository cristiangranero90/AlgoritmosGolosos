package model;

import static org.junit.Assert.*;

import org.junit.Test;

@SuppressWarnings("unused")
public class ClubTest {

	@Test (expected=RuntimeException.class)
	public void ClubNull() {
		Club club=new Club(null);
	}
	
	@Test
	public void agregarArbitroTest() {
		Club boca=new Club("Boca");
		Arbitro arbitro=new Arbitro(1);
		boca.agregarArbitro(arbitro);
		assertTrue (boca.getArbitros().containsKey(arbitro));
	}
	@Test
	public void dameCantAparicionesTest () {
		Club boca=new Club("Boca");
		Arbitro arbitro=new Arbitro(1);
		boca.agregarArbitro(arbitro);
		assertEquals(1,boca.dameCantidadApariciones(arbitro));
	}

}
