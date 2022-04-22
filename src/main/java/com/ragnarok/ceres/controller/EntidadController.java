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
@RequestMapping("/ceres/entidades")
public class EntidadController {

	@Autowired
	private EntidadService entidadService;

	// Crear nuevo registro
	@PostMapping // Tambien se puede usar @RequestMapping(POST)
	public ResponseEntity<?> salvar(@RequestBody Entidad entidad) {
		return ResponseEntity.status(HttpStatus.CREATED).body(entidadService.salvar(entidad));
	}

	// Leer registro
	@GetMapping("/{entidadId}")
	public ResponseEntity<?> leer(@PathVariable() Long entidadId) {
		Optional<Entidad> oEntidad = entidadService.buscarPorId(entidadId); // Se utiliza Optional para evitar error

		if (oEntidad.isPresent()) { // Si no trae null
			return ResponseEntity.ok(oEntidad);
		} else {
			return ResponseEntity.notFound().build(); // Retorna el codigo 404
		}
	}

	// Actualizar
	@PutMapping("/{entidadId}")
	public ResponseEntity<?> actualizar(@RequestBody Entidad entidadActualizada, @PathVariable() Long entidadId) {
		Optional<Entidad> oEntidad = entidadService.buscarPorId(entidadId);

		if (oEntidad.isPresent()) {
			oEntidad = Optional.ofNullable(entidadActualizada);

			return ResponseEntity.status(HttpStatus.CREATED).body(entidadService.salvar(oEntidad.get()));
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	// Borrar
	@DeleteMapping("/{entidadId}")
	public ResponseEntity<?> borrar(@PathVariable() Long entidadId) {
		Optional<Entidad> oEntidad = entidadService.buscarPorId(entidadId);

		if (oEntidad.isPresent()) {
			entidadService.eliminarPorId(entidadId);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Leer todo
	@GetMapping
	public Iterable<Entidad> leerTodo() {
		return entidadService.buscarTodos();
	}

}
