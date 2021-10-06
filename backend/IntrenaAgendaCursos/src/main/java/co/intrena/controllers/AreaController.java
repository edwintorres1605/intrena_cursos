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

import co.intrena.model.entity.Area;
import co.intrena.model.services.AreaService;

@RestController
@RequestMapping("/api/areas")
public class AreaController {
	
	@Autowired
	private AreaService areaService;
	
	
	@GetMapping("{id}")
	public Optional<Area> buscarPorId(@PathVariable Integer id){
		return areaService.findById(id);
	}
	
	@GetMapping("/listar")
	public List<Area> listar(){
		return areaService.findAll();
	}
	
	@PostMapping
	public Area guardar(@RequestBody Area area) {
		return areaService.save(area);
	}
	
	@DeleteMapping("{id}")
	public void eliminar(@PathVariable Integer id) {
		areaService.deleteById(id);
	}
	
	@PutMapping ("/actualizar/{id}")
	public Area actualizar(@RequestBody Area area , @PathVariable Integer id) {
		
		Area areaEnBD= areaService.findById(id).get();
		
		//System.out.println("c por body: "+area);
		//System.out.println("en DB"+areaEnBD);
		
		areaEnBD.setNombre(area.getNombre()); 
		//System.out.println("asi quedo en DB"+areaEnBD);
		
		areaService.save(areaEnBD);
		return area;
	}

}
