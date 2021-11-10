package model;

import static org.junit.Assert.*;

import org.junit.Test;

@SuppressWarnings(value = { "unused" })
public class SolverTest {

	@Test (expected= RuntimeException.class)
	public void testagregarAparicionArbitroTestNull() {
		Campeonato campeonato=new Campeonato();
		Solver solver=new Solver (campeonato, null);
		solver.agregarAparicionesArbitro(null, null);
		
	}
	
	@Test
	public void testagregarAparicionArbitroTest() {
		Campeonato campeonato=new Campeonato();
		Solver solver=new Solver (campeonato, null);
		Club boca=new Club("Boca");
		Arbitro arbitro=new Arbitro(2);
		solver.agregarAparicionesArbitro(boca, arbitro);
		assertTrue(solver.getAsignacionArbitros().containsKey(boca));
		assertTrue(solver.getAsignacionArbitros().containsValue(arbitro));
		
		
	}
	
	@Test
	public void ordenarArbitrosTest() {
		Campeonato campeonato=new Campeonato();
		Solver solver=new Solver (campeonato, new OrdenarPorAparicion());
		Arbitro arbitro=new Arbitro(1);
		Arbitro arbitro2=new Arbitro(2);
		Arbitro arbitro3=new Arbitro(3);
		campeonato.agregarArbitro(arbitro);
		campeonato.agregarArbitro(arbitro2);
		campeonato.agregarArbitro(arbitro3);
		solver.ordenarArbitros(campeonato.getArbitrosDisponibles());
		assertEquals(arbitro,campeonato.getArbitrosDisponibles().get(0));
		assertEquals(arbitro2,campeonato.getArbitrosDisponibles().get(1));
		assertEquals(arbitro3,campeonato.getArbitrosDisponibles().get(2));
		
	}
	
	@Test
	public void revisarClubConArbitroTest () {
		Solucion solucion=new Solucion();
		Campeonato campeonato=new Campeonato();
		Club boca=new Club("Boca");
		Club river=new Club("River");
		Club velez=new Club("Velez");
		Partido partido=new Partido(boca,river);
		Fecha fecha=new Fecha(1);
		fecha.agregarPartido(partido);
		campeonato.agregarFechas(fecha);
		Arbitro arbitro=new Arbitro(1);
		campeonato.agregarArbitro(arbitro);
		Solver solver=new Solver (campeonato, new OrdenarPorAparicion());
		
		solver.resolver().getArbitrosSeleccionados().contains(arbitro);
		assertTrue (solver.resolver().getArbitrosSeleccionados().contains(arbitro));
		assertTrue(solver.resolver().getAparicionesClub().containsValue(1));
		assertTrue(solver.resolver().getAparicionesClub().containsKey(boca));
		
		
	}
	
	
	
	
	

}
