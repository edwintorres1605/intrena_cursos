package co.intrena.controllers;
import java.util.List;
import java.util.Optional;

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
import co.intrena.security.JWTUtil;


@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired 
	private JWTUtil jwtUtil;
	
	@GetMapping("/{id}")
	public Optional<Usuario> buscarPorId(@PathVariable Long id){
		return usuarioService.findById(id);
	}
	
	@GetMapping("/listar")
	public List<Usuario> listar(){
		return usuarioService.findAll();
	}
	
	@PostMapping
	public Usuario guardar(@RequestBody Usuario usuario) {
		return usuarioService.save(usuario);
	}	
	
	@PutMapping
	public Usuario actualizar(@RequestBody Usuario usuario) {
		
		Usuario usuarioEnBD= usuarioService.findById(usuario.getId()).get();
		
		usuarioEnBD.setNombre(usuario.getNombre()); 
		usuarioEnBD.setPassword(usuario.getPassword());
		usuarioEnBD.setEmail(usuario.getEmail());
		usuarioEnBD.setFotoPerfil(usuario.getFotoPerfil());
		
		return usuarioService.save(usuarioEnBD);
	}
	
	@DeleteMapping("{id}")
	public void eliminar(@PathVariable Long id) {
		usuarioService.deleteById(id);
	}
	
	@GetMapping("/validar")
	public String validar(@RequestBody Usuario usuario)
	{
		String email = usuario.getEmail();
		String ctr = usuario.getPassword();
		Usuario user = usuarioService.findById(usuarioService.ConsultarPorCredenciales(ctr, email)).get();
		
		if (user != null)
		{
			//Crear jwt
			String token = jwtUtil.crearToken(String.valueOf(user.getId()), user.getEmail());
			return token;
		}else
		{
			return "incorrecto";
		}
	}
	
}