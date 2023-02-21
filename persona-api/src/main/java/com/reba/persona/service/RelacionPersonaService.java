package com.reba.persona.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reba.persona.entity.Persona;
import com.reba.persona.entity.Relacion;
import com.reba.persona.entity.RelacionPersona;
import com.reba.persona.repository.RelacionPersonaRepository;

@Service
public class RelacionPersonaService {

	private static final int RELACION_PADRE = 1;
	

	@Autowired
	RelacionPersonaRepository relacionPersonaRepository;

	public RelacionPersona relacionarPersonaPadre(Integer id1, Integer id2) {
		RelacionPersona relacionPersona = relacionPersonaMap(id1,id2,RELACION_PADRE);
		return relacionPersonaRepository.save(relacionPersona);
	}
	
	public RelacionPersona guardarRelacion(Integer persona1Id,Integer persona2Id,Integer tipoRelacion) {
		RelacionPersona relacionPersona = relacionPersonaMap(persona1Id, persona2Id, tipoRelacion);
		return relacionPersonaRepository.save(relacionPersona);
	}

	public String obteneRelacionPersona1YPersona2(Integer per1,Integer per2) {
		Persona persona1 = Persona.builder().id(per1).build();
		Persona persona2 = Persona.builder().id(per2).build();
		Relacion padre = Relacion.builder().id(RELACION_PADRE).build();
		
		Optional<RelacionPersona> relacionPersona = relacionPersonaRepository.findByPersona1AndPersona2AndRelacionIsNot(persona1, persona2, padre);
		Relacion relacion = relacionPersona.map(RelacionPersona::getRelacion).orElse(new Relacion());
		String tipoRelacion = Optional.ofNullable(relacion.getTipoRelacion()).orElseGet(this::noExisteRelacion);
		return tipoRelacion;
		
	}
	
	public String noExisteRelacion() {
	    return "No existe relacion ,HERMAN@, TI@ ,PRIM@. Para estas dos personas";
	}

	private RelacionPersona relacionPersonaMap(Integer id1,Integer id2,Integer relacionId) {
		Persona persona1 = Persona.builder().id(id1).build();
		Persona persona2 = Persona.builder().id(id2).build();
		Relacion relacion = Relacion.builder().id(relacionId).build();
		RelacionPersona relacionPersona = RelacionPersona.builder().persona1(persona1).persona2(persona2)
				.relacion(relacion).build();
		return relacionPersona;
	}
}
