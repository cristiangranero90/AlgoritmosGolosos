package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Club;
import model.Fecha;
import model.Partido;

public class FechaTest {

	@Test
	public void agregarPartidoTest() {
		Fecha fecha= new Fecha (1);
		Club boca=new Club("Boca");
		Club river=new Club("River");
	
		Partido partido1=new Partido(boca,river);
	
		fecha.agregarPartido(partido1);
	
		assertTrue(fecha.getPartidos().contains(partido1));
	}
	
	@Test 
	public void cantidadPartidosTest() {
		Fecha fecha= new Fecha (1);
		Club boca=new Club("Boca");
		Club river=new Club("River");
	
		Partido partido1=new Partido(boca,river);
	
		fecha.agregarPartido(partido1);
		assertEquals(1,fecha.cantidadPartidos());
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void partidosRepetidos() {
		Fecha fecha= new Fecha (1);
		Club boca=new Club("Boca");
		Club river=new Club("River");
		Club velez=new Club("Velez");
		Partido partido1=new Partido(boca,river);
		Partido partido2=new Partido (velez,river);
		fecha.agregarPartido(partido1);
		fecha.agregarPartido(partido2);
	}
	
	
	
	@Test 
	public void damePartidoTest () {
		Fecha fecha= new Fecha (1);
		Club boca=new Club("Boca");
		Club river=new Club("River");
		Partido partido1=new Partido(boca,river);
		fecha.agregarPartido(partido1);
		assertEquals (partido1,fecha.damePartido(0));
		
	}
	
	
	
	@Test
	public void existenArbitros() {
		Fecha fecha= new Fecha (1);
		Club boca=new Club("Boca");
		Club river=new Club("River");
		Partido partido1=new Partido(boca,river);
		fecha.agregarPartido(partido1);
		assertFalse (fecha.existenArbitros());
		
	}
	
	
	

}
