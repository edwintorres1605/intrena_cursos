package co.intrena.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.intrena.model.entity.Usuario;
import co.intrena.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> findById(Integer Id) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(Id);
	}

	@Override
	public Usuario save(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioRepository.save(usuario);
		
	}


	@Override
	public void deleteById(Integer Id) {
		// TODO Auto-generated method stub
		usuarioRepository.deleteById(Id);
	}

}
