package com.reba.persona.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "tipo_documento")
public class TipoDocumento implements  Serializable{
	
  	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;

	@Id
    @Column(name="id_tipo_documento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
	@JsonIgnore
	@Column(name = "tipo_documento")
	private String tipoDocumento;

}
