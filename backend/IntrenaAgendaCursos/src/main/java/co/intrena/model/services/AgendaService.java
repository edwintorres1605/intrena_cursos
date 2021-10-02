package co.intrena.model.services;

import java.util.List;
import java.util.Optional;

import co.intrena.model.entity.Agenda;

public interface AgendaService {
	
	
	public List<Agenda>findAll();
	public Optional<Agenda>findById(Integer Id);
	public Agenda save(Agenda agenda);
	public void deleteById(Integer Id);
	
	

}
