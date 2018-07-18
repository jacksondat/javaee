package com.jariast.javaee.sga.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.jariast.javaee.sga.dao.PersonaDAO;
import com.jariast.javaee.sga.domain.Persona;
import com.jariast.javaee.sga.service.PersonaService;
import com.jariast.javaee.sga.service.PersonaServiceRemote;

@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote, PersonaService {

	@Inject
	PersonaDAO personaDao;
	
	@Override
	public List<Persona> listarPersonas() {		
		return personaDao.findAllPersonas();
	}

	@Override
	public Persona encontrarPersonaPorId(Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona encontrarPersonaPorEmail(Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registrarPersona(Persona persona) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarPersona(Persona persona) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarPersona(Persona persona) {
		// TODO Auto-generated method stub

	}

}
