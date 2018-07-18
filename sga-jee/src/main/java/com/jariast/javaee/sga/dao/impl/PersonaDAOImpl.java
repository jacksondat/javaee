package com.jariast.javaee.sga.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jariast.javaee.sga.dao.PersonaDAO;
import com.jariast.javaee.sga.domain.Persona;

@Stateless
public class PersonaDAOImpl implements PersonaDAO {
	
	@PersistenceContext(unitName = "PersonaPU")
	EntityManager em;

	@Override
	public List<Persona> findAllPersonas() {
		return em.createNamedQuery("persona.findAll", Persona.class).getResultList();
	}

}
