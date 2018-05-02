package com.jariast.javaee.beans;

import static org.junit.Assert.*;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

public class DemoEJBTest {
	
	private EJBContainer contenedor;
	private Context contexto;
	private DemoEJB ejb;

	@Before
	public void iniciarContenedor() throws NamingException {
		contenedor = EJBContainer.createEJBContainer();
		contexto = contenedor.getContext();
		//ejb = (DemoEJB) contexto.lookup("java:global/bin/DemoEJB!com.jariast.javaee.beans.DemoEJB");
		ejb = (DemoEJB) contexto.lookup("java:global/main/DemoEJB!com.jariast.javaee.beans.DemoEJB");
		
	}
	
	@Test
	public void sumarTest() {
		int a = 1;
		int b = 2;
		int resultado = ejb.sumar(a, b);
		
		assertEquals(a + b, resultado);
	}

}
