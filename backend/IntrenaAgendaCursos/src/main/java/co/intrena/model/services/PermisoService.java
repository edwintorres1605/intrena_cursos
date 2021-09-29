package co.intrena.model.services;

import java.util.List;
import java.util.Optional;

import co.intrena.model.entity.Permiso;

public interface PermisoService {

	public List<Permiso>findAll();
	public Optional<Permiso>findById(Integer Id); 
	public Permiso save(Permiso permiso);
	public void deleteById(Integer Id);
	
	
}
