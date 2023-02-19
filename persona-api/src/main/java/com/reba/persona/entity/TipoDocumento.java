package com.reba.persona.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


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
    
	@Column(name = "tipo_documento")
	private String tipoDocumento;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	

}
