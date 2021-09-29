package co.intrena.controllers;
import java.util.List;
import java.util.Optional;

//Aqui se crean lo métodos
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.intrena.model.entity.Usuario;
import co.intrena.model.services.UsuarioService;


@RestController

@RequestMapping("/api/usuarios")

public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	@GetMapping("/{Id}")
	
	public Optional<Usuario> buscarPorId(@PathVariable Integer Id){
		usuarioService.findById(Id);
		return usuarioService.findById(Id);
	}
	@GetMapping("/listar")
	public List<Usuario> listar(){
		return usuarioService.findAll();
	}
	
	@PostMapping
	
	public Usuario guardar(@RequestBody Usuario usuario) {
		return usuarioService.save(usuario);
	}
	
	@DeleteMapping("{Id}")
	public void eliminar(@PathVariable Integer Id) {
		usuarioService.deleteById(Id);
	}
	
	@PutMapping ("/actualizar/{id}")
	public Usuario actualizar(@RequestBody Usuario usuario , @PathVariable Integer id) {
		
		Usuario usuarioEnBD= usuarioService.findById(id).get();
		
		System.out.println("usuario por body: "+usuario);
		System.out.println("en DB"+usuarioEnBD);
		usuarioEnBD.setNombre(usuario.getNombre()); 
		usuarioEnBD.setPassword(usuario.getPassword());
		usuarioEnBD.setEmail(usuario.getEmail());
		usuarioEnBD.setFotoPerfil(usuario.getFotoPerfil());
		System.out.println("asi quedo en DB"+usuarioEnBD);
		
		usuarioService.save(usuarioEnBD);
		return usuario;
	}
	
}