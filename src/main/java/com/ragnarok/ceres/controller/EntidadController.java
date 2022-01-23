package com.ragnarok.ceres.controller;

import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import com.ragnarok.ceres.models.entity.Entidad;
import com.ragnarok.ceres.service.EntidadService;

@RestController
@RequestMapping("/entidades")
public class EntidadController {
	
	@Autowired
	private EntidadService entidadService;
	
	
	//Crear nuevo
	@PostMapping //Tambien se puede usar @RequestMapping(POST)
	public ResponseEntity<?> crear(@RequestBody Entidad entidad){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(entidadService.save(entidad));
	}
	
	//Leer
	@GetMapping("/{entidadId}")
	public ResponseEntity<?> leer(@PathVariable() Long entidadId){
		Optional<Entidad> oEntidad = entidadService.findById(entidadId);	//Se utiliza Optional para evitar error cuando es null
		
		if (!oEntidad.isPresent()) {	//Si trae null
			return ResponseEntity.notFound().build();	//Retorna el codigo 404
		} 
		
		return ResponseEntity.ok(oEntidad);
	}
	
	//Actualizar
	@PutMapping("/{entidadId}")
	public ResponseEntity<?> actualizar(@RequestBody Entidad entidadDetails, @PathVariable() Long entidadId){
		Optional<Entidad> oEntidad = entidadService.findById(entidadId);
		
		if (!oEntidad.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		oEntidad.get().setNombre(entidadDetails.getNombre());
		oEntidad.get().setSituacion(entidadDetails.getSituacion());
		oEntidad.get().setSucursal(entidadDetails.getSucursal());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(entidadService.save(oEntidad.get()));
	}
	
	
	//Borrar
	@DeleteMapping("/{entidadId}")
	public ResponseEntity<?> borrar(@PathVariable() Long entidadId){
		
		if (!entidadService.findById(entidadId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		entidadService.deleteById(entidadId);
		
		return ResponseEntity.ok().build();
	}
	
	
	//Leer todo
	@GetMapping
	public Iterable<Entidad> leerTodo(){
		
		return entidadService.findAll();
	}
	
}
