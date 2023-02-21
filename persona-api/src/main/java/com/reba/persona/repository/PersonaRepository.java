package com.reba.persona.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reba.persona.entity.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
	@Query(value = "select count(*) from persona",nativeQuery = true)
	Integer cantPersonas();
	
	@Query(value = "select  pa.nombre, count(per.nombre) * 100 / (select count(*) from persona) from persona per join pais pa on pa.id_pais = per.pais_id_pais group by pa.nombre",nativeQuery = true)
	List<Object[]> cantPersonasPorPaises();
}
