package com.jariast.javaee.sga.client;

import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jariast.javaee.sga.domain.Persona;
import com.jariast.javaee.sga.service.PersonaServiceRemote;

public class PersonaServiceIPCLient {
	
	public static void main(String[] args) {
		try {
			Properties jndiProps = new Properties();
			jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
			jndiProps.put(Context.PROVIDER_URL,"http-remoting://localhost:8080");
			// username
			jndiProps.put(Context.SECURITY_PRINCIPAL, "admin");
			// password
			jndiProps.put(Context.SECURITY_CREDENTIALS, "admin");
            
            Context jndi = new InitialContext(jndiProps);
			
			PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("sga-jee/PersonaServiceImpl!com.jariast.javaee.sga.service.PersonaServiceRemote");
            
			List<Persona> personas = personaService.listarPersonas();
			
			for (Persona persona : personas) {
				System.out.println(persona);
			}
			
			System.out.println(personas.size());
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
