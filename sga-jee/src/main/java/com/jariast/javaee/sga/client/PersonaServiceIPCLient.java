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
			Properties props = new Properties();
            props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
            props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");

            // optional. Default localhost. Aqui se cambia la IP del servidor donde está Glassfish
            props.setProperty("org.omg.CORBA.ORBInitialHost", "127.0.0.1");

            // optional. Puerto por Default 3700. Solo se necesita cambiar si el puerto no es 3700.
            //props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
            
            Context jndi = new InitialContext(props);
			
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
