package com.reba.persona.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Service;

import com.reba.persona.entity.Persona;
import com.reba.persona.entity.Stats;
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
	
	public List<Map<String,Double>> stats() {
		return personaRepository.cantPersonasPorPaises();
		
	}
}
