package com.reba.persona.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "relacion_persona")
public class RelacionPersona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_relacion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	

	@JoinColumn(name = "persona_1")
	private Persona persona1;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "relacion")
	private Relacion relacion;	

	@JoinColumn(name = "persona_2")
	private Persona persona2;
}
