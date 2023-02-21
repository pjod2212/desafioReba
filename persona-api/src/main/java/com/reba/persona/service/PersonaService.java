package com.reba.persona.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reba.persona.entity.Persona;
import com.reba.persona.repository.PersonaRepository;

@Service
public class PersonaService {

	@Autowired
	PersonaRepository personaRepository;

	public List<Persona> listarPersonas() {
		return personaRepository.findAll();
	}

	public Persona obtenerPersona(Integer id) {
		return personaRepository.findById(id).get();
	}

	public Persona guardarPersona(Persona persona) {

		if (persona.getEdad() < 18) {
			throw new RuntimeException("No puede ingresar una persona menor a 18 años");
		}
		return personaRepository.save(persona);
	}

	public void borrar(Integer id) {
		personaRepository.deleteById(id);
	}
}
