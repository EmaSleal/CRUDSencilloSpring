
package com.api.v1.ema_h2.repo;

import com.api.v1.ema_h2.model.Persona;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface PersonaRepository extends CrudRepository<Persona, Long> {
	public List<Persona> findByNombre(String nombre);
}
