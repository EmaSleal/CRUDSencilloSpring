package com.api.v1.ema_h2.service;

import com.api.v1.ema_h2.model.Persona;
import com.api.v1.ema_h2.repo.PersonaRepository;
import java.util.Collection;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class PersonaServiceImpl implements PersonaService {

	private final PersonaRepository Pr;

	@Override
	public Collection<Persona> listar() {
		log.info("recuperando personas de la base de datos");

		return (Collection<Persona>) Pr.findAll();
	}

	@Override
	public Persona guardar(Persona persona) {
		log.info("guardando persona en la base de datos: {}", persona);
		Pr.save(persona);
		return persona;
	}

	@Override
	public List<Persona> buscarPorNombre(String nombre) {
		log.info("buscando persona en la base de datos id: {}", nombre);
		return Pr.findByNombre(nombre);
	}

	@Override
	public Persona eliminar(Long id) {
		Persona persona = Pr.findById(id).orElse(null);
		log.info("eliminando persona en la base de datos id: {}", persona.getNombre());

		if (persona == null) {
			return new Persona();
		}
		Pr.deleteById(persona.getId());
		return persona;
	}

	@Override
	public Persona editar(Persona persona) {
		
		log.info("editando persona en la base de datos: {}",persona);
		return Pr.save(persona);
	}

}
