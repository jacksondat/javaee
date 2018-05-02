package com.jariast.javaee.sga.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.jariast.javaee.sga.domain.Persona;
import com.jariast.javaee.sga.service.PersonaServiceRemote;

@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote {

	@Override
	public List<Persona> listarPersonas() {
		List<Persona> personas = new ArrayList<>();
		
		personas.add(new Persona(1, "Jackson", "Arias", "jackson@sga.com", "123456"));
		personas.add(new Persona(2, "Kevin", "Arias", "kevin@sga.com", "654321"));
		
		return personas;
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
