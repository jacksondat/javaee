package com.jariast.javaee.demo.domain;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PersonaJPATest {

	static EntityManagerFactory emf;
	EntityManager em;
	
	Logger log = LogManager.getRootLogger();
	
	@BeforeClass
	public static void init(){
		emf = Persistence.createEntityManagerFactory("PersonaPU");
	}
	
	@Before
	public void setup(){
		try {
            em = emf.createEntityManager();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	
	@Test
	public void insertPersonaTest() {

		assertTrue(em != null);
		
		EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        Persona persona1 = new Persona();
        persona1.setName("Jackson");
        persona1.setLastname("Arias");
        persona1.setEmail("jacksondat@gmail.com");
        persona1.setPhone("123");

        em.persist(persona1);
        tx.commit();

        assertTrue(persona1.getId() != 0);

        log.debug("Objeto persistido:" + persona1);		
	}
	
	@After
	public void close(){
		if(em != null){
			em.close();
		}		
	}

}
