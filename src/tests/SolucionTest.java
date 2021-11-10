package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Arbitro;
import model.Club;
import model.Solucion;

public class SolucionTest {

	@Test
	public void agregarArbitroSolucionTest (){
		Solucion solucion=new Solucion();
		Arbitro arbitro=new Arbitro (1);
		solucion.agregarArbitroSolucion(arbitro);
		assertTrue(solucion.getArbitrosSeleccionados().contains(arbitro));
	}
	@Test (expected= RuntimeException.class)
	public void agregarArbitroSolucionNull (){
		Solucion solucion=new Solucion();
		solucion.agregarArbitroSolucion(null);
	}
	
	@Test (expected= RuntimeException.class)
	public void dameArbitroIndiceIncorrecto() {
		Solucion solucion=new Solucion();
		Arbitro arbitro=new Arbitro(1);
		Arbitro arbitro2=new Arbitro(2);
		solucion.agregarArbitroSolucion(arbitro2);
		solucion.agregarArbitroSolucion(arbitro);
		solucion.dameArbitro(3);
		
	}
	
	@Test 
	public void dameArbitroTest() {
		Solucion solucion=new Solucion();
		Arbitro arbitro=new Arbitro(1);
		Arbitro arbitro2=new Arbitro(2);
		solucion.agregarArbitroSolucion(arbitro2);
		solucion.agregarArbitroSolucion(arbitro);
		assertEquals(arbitro,solucion.dameArbitro(1));
		
	}
	
	@Test 
	public void tamanioAparArbitroTest() {
		Solucion solucion=new Solucion();
		Club boca=new Club ("Boca");
		Club river=new Club ("River");
		solucion.agregarAparicionesClub(boca);
		solucion.agregarAparicionesClub(river);
		Arbitro arbitro=new Arbitro(1);
		Arbitro arbitro2=new Arbitro(2);
		solucion.agregarArbitroSolucion(arbitro2);
		solucion.agregarArbitroSolucion(arbitro);
		assertEquals(2,solucion.tamanoAparicionesArbitro());
		
	}

}
