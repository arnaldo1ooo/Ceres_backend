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

import com.ragnarok.ceres.models.entity.Sucursal;
import com.ragnarok.ceres.service.SucursalService;

@RestController
@RequestMapping("/ceres/sucursales")
public class SucursalController {
	
	@Autowired
	private SucursalService sucursalService;
	
	
	//Crear nuevo
	@PostMapping //Tambien se puede usar @RequestMapping(POST)
	public ResponseEntity<?> crear(@RequestBody Sucursal sucursal){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(sucursalService.save(sucursal));
	}
	
	//Leer
	@GetMapping("/{sucursalId}")
	public ResponseEntity<?> leer(@PathVariable() Long sucursalId){
		Optional<Sucursal> oSucursal = sucursalService.findById(sucursalId);	//Se utiliza Optional para evitar error cuando es null
		
		if (!oSucursal.isPresent()) {	//Si trae null
			return ResponseEntity.notFound().build();	//Retorna el codigo 404
		} 
		
		return ResponseEntity.ok(oSucursal);
	}
	
	//Actualizar
	@PutMapping("/{sucursalId}")
	public ResponseEntity<?> actualizar(@RequestBody Sucursal sucursalDetails, @PathVariable() Long sucursalId){
		Optional<Sucursal> oSucursal = sucursalService.findById(sucursalId);
		
		if (!oSucursal.isPresent()) {
			return ResponseEntity.notFound().build();
		}
			
		//BeanUtils.copyProperties(departamentoDetails, oDepartamento);	Sirve para copiar directamente todo el objeto departamentoDetails a oDepartamento
		
		oSucursal.get().setNombre(sucursalDetails.getNombre());
		oSucursal.get().setMunicipio(sucursalDetails.getMunicipio());
		oSucursal.get().setBarrio(sucursalDetails.getBarrio());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(sucursalService.save(oSucursal.get()));
	}
	
	
	//Borrar
	@DeleteMapping("/{sucursalId}")
	public ResponseEntity<?> borrar(@PathVariable() Long sucursalId){
		
		if (!sucursalService.findById(sucursalId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		sucursalService.deleteById(sucursalId);
		
		return ResponseEntity.ok().build();
	}
	
	
	//Leer todo
	@GetMapping
	public Iterable<Sucursal> leerTodo(){
		
		return sucursalService.findAll();
	}
	
}
