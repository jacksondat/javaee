package com.jariast.javaee.sga.dao;

import java.util.List;

import com.jariast.javaee.sga.domain.Persona;

public interface PersonaDAO {
	List<Persona> findAllPersonas();
}
