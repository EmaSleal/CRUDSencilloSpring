
package com.api.v1.ema_h2.service;

import com.api.v1.ema_h2.model.Persona;
import java.util.Collection;
import java.util.List;


public interface PersonaService {
	public Collection<Persona> listar();
	
	public Persona guardar(Persona persona);
	
	public List<Persona> buscarPorNombre(String nombre);
	
	public Persona eliminar(Long id);
	
	public Persona editar(Persona persona);
}
