package co.intrena.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.intrena.model.entity.Curso;
import co.intrena.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoRepository cursoRepository;//este atributo trae los métodos
	//cuando le pongo punto al final a este atributo, va listando los métodos
	
	@Override
	public List<Curso> findAll() {
		// TODO Auto-generated method stub
		return cursoRepository.findAll();
	}

	@Override
	public Optional<Curso> findById(Integer Id) {
		// TODO Auto-generated method stub
		return cursoRepository.findById(Id);
	}

	@Override
	public Curso save(Curso curso) {
		// TODO Auto-generated method stub
		return cursoRepository.save(curso);
		
	}


	@Override
	public void deleteById(Integer Id) {
		// TODO Auto-generated method stub
		cursoRepository.deleteById(Id);	//para que borre por Id
	}

}
