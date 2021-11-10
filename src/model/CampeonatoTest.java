package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CampeonatoTest {
	
	@Test 
	public void asignarSolucionTest() {
		Campeonato campeonato=new Campeonato();
		Solucion solucion=new Solucion();
		Arbitro arbitro=new Arbitro(1);
		Club boca=new Club ("Boca");
		Club river=new Club ("River");
		Partido partido=new Partido(boca,river);
		Fecha fecha=new Fecha(1);
		fecha.agregarPartido(partido);
		campeonato.agregarFechas(fecha);
		campeonato.agregarArbitro(arbitro);
		campeonato.asignarSolucion(solucion);
		assertTrue(solucion.getArbitrosSeleccionados().contains(arbitro));
		assertTrue(solucion.getAparicionesClub().containsKey(boca));
	}

	@Test
	public void fechaExistente() {
		Fecha fecha=new Fecha(1);
		Campeonato campeonato=new Campeonato();
		campeonato.agregarFechas(fecha);
		assertTrue (campeonato.existeFecha(fecha));
	}
	
	@Test (expected=RuntimeException.class)
	public void agregarFechaNull () {
		Campeonato campeonato=new Campeonato();
		campeonato.agregarFechas(null);
	}
	
	@Test
	public void agregarFechaTest () {
		Fecha fecha=new Fecha(1);
		Campeonato campeonato=new Campeonato();
		campeonato.agregarFechas(fecha);
		assertTrue(campeonato.getFechas().contains(fecha));
	}
	
	@Test (expected=RuntimeException.class)
	public void existeFechaNull() {
		Campeonato campeonato=new Campeonato();
		campeonato.agregarFechas(null);
	}
	
	@Test
	public void existeFechaTest () {
		Campeonato campeonato=new Campeonato();
		Fecha fecha1= new Fecha(1);
		Fecha fecha2= new Fecha(2);
		campeonato.agregarFechas(fecha1);campeonato.agregarFechas(fecha2);
		assertTrue(campeonato.existeFecha(fecha2));
		assertTrue(campeonato.existeFecha(fecha1));
	}
	
	@Test (expected=RuntimeException.class)
	public void existeArbitroNull() {
		Campeonato campeonato=new Campeonato();
		campeonato.agregarArbitro(null);
	}
	
	@Test
	public void existeArbitroTest () {
		Arbitro arb= new Arbitro(1);
		Campeonato campeonato=new Campeonato();
		campeonato.agregarArbitro(arb);
		assertTrue (campeonato.existeArbitro(arb));
	}
	
	@Test
	public void dameFecha () {
		Campeonato campeonato=new Campeonato();
		Fecha fecha1= new Fecha(1);
		Fecha fecha2= new Fecha(2);
		campeonato.agregarFechas(fecha1);campeonato.agregarFechas(fecha2);
		assertEquals (fecha1,campeonato.dameFecha(1));
		
		
	}
	
	@Test 
	public void dameCantidadPartidos () {
		Club boca=new Club("Boca");
		Club river=new Club("River");
		Partido partido1=new Partido(boca,river);
		Partido partido2=new Partido (boca,river);
		Fecha fecha1= new Fecha(1);
		fecha1.agregarPartido(partido1);
		fecha1.agregarPartido(partido2);
		
		assertEquals (2, fecha1.cantidadPartidos());
	}
	
	@Test 
	public void agregarArbitros() {
		Campeonato campeonato=new Campeonato();
		Arbitro arb= new Arbitro(1);
		Arbitro arb2= new Arbitro(2);
		campeonato.agregarArbitro(arb);
		campeonato.agregarArbitro(arb2);
		assertEquals (2,campeonato.getCantidadArbitros());
		
		
	}
	
	@Test
	public void cantidadFechasTest() {
		Campeonato campeonato=new Campeonato();
		Club boca=new Club("Boca");
		Club river=new Club("River");
		
		Partido partido=new Partido(boca,river);
		
		Fecha fecha=new Fecha(1);
		fecha.agregarPartido(partido);
		campeonato.agregarFechas(fecha);
		assertEquals(1,campeonato.cantFechas());
		
	}
	
	@Test (expected=RuntimeException.class)
	public void cantidadPartidosFechaNegativa() {
		Campeonato campeonato=new Campeonato();
		campeonato.cantidadDePartidos(0);
	}
	
	@Test
	public void cantidadPartidosTest() {
		Campeonato campeonato=new Campeonato();
		Club boca=new Club("Boca");
		Club river=new Club("River");
		Club velez=new Club("Velez");
		Club racing=new Club("Racing");
		Partido partido=new Partido(boca,river);
		Partido partido2=new Partido(velez,racing);
		Fecha fecha=new Fecha(1);
		fecha.agregarPartido(partido);
		fecha.agregarPartido(partido2);
		campeonato.agregarFechas(fecha);
		assertEquals(2,campeonato.cantidadDePartidos(0));
	}
	
	@Test 
	public void arbitrosAsignadosTest() {
		Campeonato campeonato=new Campeonato();
		Arbitro arb= new Arbitro(1);
		Arbitro arb2= new Arbitro(2);
		campeonato.agregarArbitro(arb);
		campeonato.agregarArbitro(arb2);
		Fecha fecha=new Fecha(1);
		Club boca=new Club("Boca");
		Club river=new Club("River");
		
		Partido partido=new Partido(boca,river);
		fecha.agregarPartido(partido);
		campeonato.agregarFechas(fecha);
		assertTrue(campeonato.arbitrosAsignados());
	}
	
	@Test
	public void generarArbitrosTest () {
		Campeonato campeonato=new Campeonato();
		campeonato.generarArbitros(false, 6);
		assertEquals(5,campeonato.getArbitrosDisponibles().size());
	}
	
	

}
