package com.jariast.javaee.sga.client;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jariast.javaee.sga.domain.Persona;
import com.jariast.javaee.sga.service.PersonaServiceRemote;

public class PersonaServiceClient {

	public static void main(String[] args) {
		try {
			Context jndi = new InitialContext();
			
			PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/sga-jee/PersonaServiceImpl!com.jariast.javaee.sga.service.PersonaServiceRemote");
			
			List<Persona> personas = personaService.listarPersonas();
			
			for (Persona persona : personas) {
				System.out.println(persona);
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
