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

import co.intrena.model.entity.Curso;
import co.intrena.model.services.CursoService;

//el controlador de Rest que es quien va a recibir la ruta y va a devolver algo:
@RestController
//le indico como vienen las peticiones:
@RequestMapping("/api/cursos")

public class CursoController {
	@Autowired
	private CursoService cursoService;
	@GetMapping("/{Id}")//Este método va a ser llamado cuando me entreguen una variable que he llamado Id
	//El Id va entre{} porque es una variable que recibo
	
	public Optional<Curso> buscarPorId(@PathVariable Integer Id){//Este Id lo recibo por la URL del navegador
	//por eso se agrega @PathVariable
		cursoService.findById(Id);
		return cursoService.findById(Id);
	}
	@GetMapping("/listar")
	public List<Curso> listar(){
		return cursoService.findAll();
	}
	
	@PostMapping
	//porque ya la petición no va por la URL.Tampoco va por  Path Varibale sino por requestbody
	public Curso guardar(@RequestBody Curso curso) {
		return cursoService.save(curso);
	}
	
	@DeleteMapping("{Id}")
	public void eliminar(@PathVariable Integer Id) {
		cursoService.deleteById(Id);
	}
	
	@PutMapping ("/actualizar/{id}")
	public Curso actualizar(@RequestBody Curso curso , @PathVariable Integer id) {
		
		Curso cursoEnBD= cursoService.findById(id).get();//se consulta el id a actualizar
		
		System.out.println("c por body: "+curso);
		System.out.println("en DB"+cursoEnBD);
		//enseguida los campos de la entidad que vamos a actualizar (en este caso 2):
		cursoEnBD.setNombre(curso.getNombre()); 
		cursoEnBD.setDescripcion(curso.getDescripcion());
		System.out.println("asi quedo en DB"+cursoEnBD);
		
		cursoService.save(cursoEnBD);
		return curso;
	}
	
}
