package com.reba.persona.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "pais")
public class Pais implements Serializable{
	
	   	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

		@Id
	    @Column(name="id_pais")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;
	    
	    @Column(name="nombre")    
	    private String nombre;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		} 
	    
	    
}
