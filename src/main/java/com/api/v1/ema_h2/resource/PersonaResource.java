package com.api.v1.ema_h2.resource;

import com.api.v1.ema_h2.model.Log;
import com.api.v1.ema_h2.model.Persona;
import com.api.v1.ema_h2.repo.LogRepository;
import com.api.v1.ema_h2.service.PersonaService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@RequiredArgsConstructor
public class PersonaResource {

	private final PersonaService PS;

	@GetMapping()
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<Collection<Persona>> listar() {
		return ResponseEntity.ok().body(PS.listar());
	}

	@PostMapping()
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<Persona> guardar(@RequestBody Persona persona) {
		return ResponseEntity.ok(PS.guardar(persona));
	}

	@PutMapping("/edit")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<Persona> editar(@RequestBody Persona persona) {
		return ResponseEntity.ok(PS.editar(persona));
	}

	@GetMapping("/{nombre}")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<List<Persona>> buscarPorNombre(@PathVariable("nombre") String nombre) {
		return ResponseEntity.ok(PS.buscarPorNombre(nombre));
	}

	@DeleteMapping("/{id}")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<Persona> borrar(@PathVariable("id") Long id) {

		return ResponseEntity.ok().body(PS.eliminar(id));
	}

	private final LogRepository LR;

	@GetMapping("/Log")
	@CrossOrigin(origins = "*", maxAge = 5173)
	public ResponseEntity<List<Log>> listarLog() {
		List<Log> lista = new ArrayList<Log>();
		LR.findAll().forEach(log -> lista.add(log));
		return ResponseEntity.ok(lista);
	}

}
