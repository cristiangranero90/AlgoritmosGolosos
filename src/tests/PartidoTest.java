package model;

import static org.junit.Assert.*;

import org.junit.Test;

@SuppressWarnings("unused")
public class PartidoTest {

	@Test
	public void cantidadAparicArbitroTest() {
		Arbitro arbitro= new Arbitro(1);
		Club boca=new Club("Boca");
		Club river=new Club("River");
		boca.agregarArbitro(arbitro);
		river.agregarArbitro(arbitro);
		Partido partido=new Partido(boca,river);
		assertEquals(2,partido.cantidadAparicionesArbitro(arbitro));
	}
	
	
	@Test
	public void existeClubEnPartidoTest() {
		Club boca=new Club("Boca");
		Club river=new Club("River");
		Partido partido=new Partido(boca,river);
		//assertTrue(partido.existeClubEnPartido(river));
	}
	 
}
