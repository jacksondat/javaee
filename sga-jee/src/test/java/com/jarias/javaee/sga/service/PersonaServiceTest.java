package com.jarias.javaee.sga.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import com.jariast.javaee.sga.service.PersonaService;

public class PersonaServiceTest {

	private PersonaService personaService;
	
	@Before
	public void setUp() throws NamingException {
		EJBContainer contenedor = EJBContainer.createEJBContainer();
		//personaService = (PersonaService) contenedor.getContext().lookup("java:global/bin/PersonaServiceImpl!com.jariast.javaee.sga.service.PersonaService");
		personaService = (PersonaService) contenedor.getContext().lookup("java:global/main/PersonaServiceImpl!com.jariast.javaee.sga.service.PersonaService");
	}
	
	@Test
	public void EJBPersonaServiceTest() {
		assertTrue(personaService != null);
		
		assertEquals(personaService.listarPersonas().size(), 2);
	}

}
