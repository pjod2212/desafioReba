package com.reba.persona.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "persona", uniqueConstraints = @UniqueConstraint(name = "id_persona", columnNames = { "nro_documento",
		"pais_id_pais" ,"tipo_documento_id_tipo_documento"}))
public class Persona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;

	@Id
	@Column(name = "id_persona")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "nro_documento")
	private Integer nroDocumento;
	
	@Column(name = "edad")
    @Min(value = 18, message = "La edad no debe ser menor a 18")
	private Integer edad;

	@OneToOne
	private Pais pais;
	
	@OneToOne
	private TipoDocumento tipoDocumento;
	
	@Column(name = "email")
	@Email(message = "Formato de mail debe ser x@x.xxx")
	private String email;

	
}
