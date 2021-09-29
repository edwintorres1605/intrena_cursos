package co.intrena.model.services;

import java.util.List;
import java.util.Optional;

import co.intrena.model.entity.Usuario;

public interface UsuarioService {
	
	public List<Usuario>findAll();
	public Optional<Usuario>findById(Integer Id); 
	public Usuario save(Usuario usuario);
	public void deleteById(Integer Id);

}
