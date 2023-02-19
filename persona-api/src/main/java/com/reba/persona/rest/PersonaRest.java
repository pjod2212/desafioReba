package com.reba.persona.rest;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reba.persona.entity.Persona;
import com.reba.persona.service.PersonaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@ApiOperation("Personas API")
@RequestMapping("/personas")
public class PersonaRest {

	@Autowired
	PersonaService personaService;
	
	@ApiOperation(value = "Listar todas las personas", response = Persona.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Procesado correctamente"),
			@ApiResponse(code = 400, message = "Error al intentar obtener el recurso"),
			@ApiResponse(code = 401, message = "Sin Autorización"),
			@ApiResponse(code = 403, message = "No tiene permisos para acceder a este recurso"),
			@ApiResponse(code = 404, message = "Error, no existe el recurso") })
	@GetMapping(value = "/v1")
	public List<Persona> listarTodo() {
			return personaService.listarPersonas();
	}

	@ApiOperation(value = "Obtener Persona", response = Persona.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Procesado correctamente"),
			@ApiResponse(code = 400, message = "Error al intentar obtener el recurso"),
			@ApiResponse(code = 401, message = "Sin Autorización"),
			@ApiResponse(code = 403, message = "No tiene permisos para acceder a este recurso"),
			@ApiResponse(code = 404, message = "Error, no existe el recurso") })
	@GetMapping(value = "/v1/{id}")
	public ResponseEntity<?> obtenerPersona(@PathVariable Integer id) {
		try {
			Persona persona = personaService.obtenerPersona(id);
			return new ResponseEntity<Persona>(persona, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);
		}
	}

	@ApiOperation(value = "Dar de alta una Persona", response = Persona.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Procesado correctamente"),
			@ApiResponse(code = 400, message = "Error al intentar obtener el recurso"),
			@ApiResponse(code = 401, message = "Sin Autorización"),
			@ApiResponse(code = 403, message = "No tiene permisos para acceder a este recurso"),
			@ApiResponse(code = 404, message = "Error, no existe el recurso") })
	@PostMapping("/v1")
	public ResponseEntity<Persona> guardarPersona(@RequestBody Persona persona) {
		Persona per = personaService.guardarPersona(persona);
		// Falta crear la constraint de tipo de dni y listo.... seguir con el resto,
		// acordate de
		// poner un ejemplo en el swagger asi queda claro	
		return new ResponseEntity<>(per, HttpStatus.OK);
	}

	@ApiOperation(value = "Modificar una Persona", response = Persona.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Procesado correctamente"),
			@ApiResponse(code = 400, message = "Error al intentar obtener el recurso"),
			@ApiResponse(code = 401, message = "Sin Autorización"),
			@ApiResponse(code = 403, message = "No tiene permisos para acceder a este recurso"),
			@ApiResponse(code = 404, message = "Error, no existe el recurso") })
	@PutMapping("/v1/{id}")
	public ResponseEntity<Persona> modificar(@RequestBody Persona persona, @PathVariable Integer id) {
		try {
			Persona personaExistente = personaService.obtenerPersona(id);
			personaService.guardarPersona(personaExistente);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value = "Modificar una Persona", response = Persona.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Procesado correctamente"),
			@ApiResponse(code = 400, message = "Error al intentar obtener el recurso"),
			@ApiResponse(code = 401, message = "Sin Autorización"),
			@ApiResponse(code = 403, message = "No tiene permisos para acceder a este recurso"),
			@ApiResponse(code = 404, message = "Error, no existe el recurso") })
	@DeleteMapping("/v1/{id}")
	public ResponseEntity<?> borrarPersona(@PathVariable Integer id) {
			personaService.borrar(id);
			return new ResponseEntity<>(HttpStatus.OK);
	}

}
