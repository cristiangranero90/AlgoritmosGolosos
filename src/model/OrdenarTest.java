package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrdenarTest {

	@Test
	public void OrdenarPorApariciontest() {
		Arbitro arbitro=new Arbitro(1);
		Arbitro arbitro2=new Arbitro(2);
		arbitro.setAparicion(5);
		arbitro2.setAparicion(4);
		new OrdenarPorAparicion();
		
		
		
		
	}

}
