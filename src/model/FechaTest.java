package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class FechaTest {

	@Test
	public void agregarPartidoTest() {
		Fecha fecha= new Fecha (1);
		Club boca=new Club("Boca");
		Club river=new Club("River");
		Club velez=new Club("Velez");
		Club racing=new Club("Racing");
		Partido partido1=new Partido(boca,river);
		Partido partido2=new Partido (velez,racing);
		fecha.agregarPartido(partido1);
		fecha.agregarPartido(partido2);
		assertEquals(2,fecha.cantidadPartidos());
	}
	
	@Test(expected = RuntimeException.class)
	public void partidosRepetidos() {
		Fecha fecha= new Fecha (1);
		Club boca=new Club("Boca");
		Club river=new Club("River");
		Club velez=new Club("Velez");
		Partido partido1=new Partido(boca,river);
		Partido partido2=new Partido (velez,river);
		
	}
	
	@Test 
	public void cantPartidosTest () {
		Fecha fecha= new Fecha (1);
		Club boca=new Club("Boca");
		Club river=new Club("River");
		Club velez=new Club("Velez");
		Club racing=new Club("Racing");
		Partido partido1=new Partido(boca,river);
		Partido partido2=new Partido (velez,racing);
		fecha.agregarPartido(partido1);
		fecha.agregarPartido(partido2);
		assertEquals(2,fecha.cantidadPartidos());
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
	
	
	
	

}
