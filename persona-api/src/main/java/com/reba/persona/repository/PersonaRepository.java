package com.reba.persona.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reba.persona.entity.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
	//Persona findByNroDocumentoPais(Persona persona);
}
