package com.reba.persona.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reba.persona.entity.Persona;
import com.reba.persona.entity.Relacion;
import com.reba.persona.entity.RelacionPersona;

@Repository
public interface RelacionPersonaRepository extends JpaRepository<RelacionPersona, Integer> {
	
	Optional<RelacionPersona> findByPersona1AndPersona2AndRelacionIsNot(
			Persona persona1,Persona persona2,Relacion padre);

}
