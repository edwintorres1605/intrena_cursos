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

import co.intrena.model.entity.Agenda;
import co.intrena.model.services.AgendaService;

@RestController
@RequestMapping("/api/agenda")
public class AgendaController {
	
	
	@Autowired
	private AgendaService agendaService;
	
	@GetMapping("{id}")
	public Optional<Agenda> buscarPorId(@PathVariable Integer id){
		return agendaService.findById(id);	
	}
	
	@GetMapping ("/listar")
	public List<Agenda> listar(){
		return agendaService.findAll();
	}
	
	@PostMapping
	public Agenda guardar(@RequestBody Agenda agenda) {
		return agendaService.save(agenda);
	}
	
	@DeleteMapping("{id}")
	public void eliminar(@PathVariable Integer id) {
		agendaService.deleteById(id);
	}
	
	@PutMapping("/actualizar/{id}")
	public Agenda actualizar(@RequestBody Agenda agenda, @PathVariable Integer id) {
		
		Agenda agendaEnBd = agendaService.findById(id).get();
		
		agendaEnBd.setCursoId(agenda.getCursoId());
		agendaEnBd.setFechaInicrea(agenda.getFechaInicrea());
		agendaEnBd.setFechaFincrea(agenda.getFechaFincrea());
		agendaEnBd.setFechaIniact(agenda.getFechaIniact());
		agendaEnBd.setFechaFinact(agenda.getFechaFinact());
		agendaEnBd.setAreaId(agenda.getAreaId());
		agendaEnBd.setEstado(agenda.getEstado());
		
		agendaService.save(agendaEnBd);
		return agenda;
	}
	

}
