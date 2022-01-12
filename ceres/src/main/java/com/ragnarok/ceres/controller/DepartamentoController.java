package com.ragnarok.ceres.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
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

import com.ragnarok.ceres.models.entity.Departamento;
import com.ragnarok.ceres.service.DepartamentoService;

@RestController
@RequestMapping("/ceres/departamentos")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoService departamentoService;
	
	
	//Crear nuevo
	@PostMapping //Tambien se puede usar @RequestMapping(POST)
	public ResponseEntity<?> crear(@RequestBody Departamento departamento){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(departamentoService.save(departamento));
	}
	
	//Leer
	@GetMapping("/{id}")
	public ResponseEntity<?> leer(@PathVariable(value = "id") Long departamentoId){
		Optional<Departamento> oDepartamento = departamentoService.findById(departamentoId);	//Se utiliza Optional para evitar error cuando es null
		
		if (!oDepartamento.isPresent()) {	//Si trae null
			return ResponseEntity.notFound().build();	//Retorna el codigo 404
		} 
		
		return ResponseEntity.ok(oDepartamento);
	}
	
	//Actualizar
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@RequestBody Departamento departamentoDetails, @PathVariable(value = "id") Long departamentoId){
		Optional<Departamento> oDepartamento = departamentoService.findById(departamentoId);
		
		if (!oDepartamento.isPresent()) {
			return ResponseEntity.notFound().build();
		}
			
		//BeanUtils.copyProperties(departamentoDetails, oDepartamento);	Sirve para copiar directamente todo el objeto departamentoDetails a oDepartamento
		
		oDepartamento.get().setNombre(departamentoDetails.getNombre());
		oDepartamento.get().setSituacion(departamentoDetails.getSituacion());
		oDepartamento.get().setSucursal(departamentoDetails.getSucursal());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(departamentoService.save(oDepartamento.get()));
	}
	
	
	//Borrar
	@DeleteMapping("/{id}")
	public ResponseEntity<?> borrar(@PathVariable(value = "id") Long departamentoId){
		
		if (!departamentoService.findById(departamentoId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		departamentoService.deleteById(departamentoId);
		
		return ResponseEntity.ok().build();
	}
	
	
	//Leer todo
	@GetMapping
	public Iterable<Departamento> leerTodo(){
		
		return departamentoService.findAll();
	}
	
}
