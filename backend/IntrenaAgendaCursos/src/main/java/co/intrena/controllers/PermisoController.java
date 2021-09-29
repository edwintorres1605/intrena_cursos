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

import co.intrena.model.entity.Permiso;
import co.intrena.model.services.PermisoService;


@RestController
@RequestMapping("/api/permisos")
public class PermisoController {
	@Autowired
	private PermisoService permisoService;
	@GetMapping("/{Id}")
	
	public Optional<Permiso> buscarPorId(@PathVariable Integer Id){
		permisoService.findById(Id);
		return permisoService.findById(Id);
	}
	@GetMapping("/listar")
	public List<Permiso> listar(){
		return permisoService.findAll();
	}
	
	@PostMapping
	
	public Permiso guardar(@RequestBody Permiso permiso) {
		return permisoService.save(permiso);
	}
	
	@DeleteMapping("{Id}")
	public void eliminar(@PathVariable Integer Id) {
		permisoService.deleteById(Id);
	}
	
	@PutMapping ("/actualizar/{id}")
	public Permiso actualizar(@RequestBody Permiso permiso , @PathVariable Integer id) {
		
		Permiso permisoEnBD= permisoService.findById(id).get();
		
		System.out.println("permiso por body: "+permiso);
		System.out.println("en DB"+permisoEnBD);
		permisoEnBD.setNombre(permiso.getNombre()); 
		permisoEnBD.setDescripcion(permiso.getDescripcion());

		System.out.println("asi quedo en DB"+permisoEnBD);
		
		permisoService.save(permisoEnBD);
		return permiso;
	}
}
