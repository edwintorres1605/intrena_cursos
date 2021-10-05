package co.intrena.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.intrena.model.entity.Agenda;
import co.intrena.repository.AgendaRepository;

@Service
public class AgendaServiceImpl implements AgendaService{
	
	@Autowired
	private AgendaRepository agendaRepository;

	@Override
	public List<Agenda> findAll() {
		// TODO Auto-generated method stub
		return agendaRepository.findAll();
	}

	@Override
	public Optional<Agenda> findById(Integer Id) {
		// TODO Auto-generated method stub
		return agendaRepository.findById(Id);
	}

	@Override
	public Agenda save(Agenda agenda) {
		// TODO Auto-generated method stub
		return agendaRepository.save(agenda);
	}

	@Override
	public void deleteById(Integer Id) {
		// TODO Auto-generated method stub
		agendaRepository.deleteById(Id);
	}

}
