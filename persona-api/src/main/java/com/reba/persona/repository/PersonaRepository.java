package com.reba.persona.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reba.persona.entity.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
	
	@Query(value = "select pa.nombre country, count(per.nombre) * 100 / (select count(*) from persona) percentage from persona per join pais pa on pa.id_pais = per.pais_id_pais group by pa.nombre",nativeQuery = true)
	List<Map<String,Double>> cantPersonasPorPaises();
}
