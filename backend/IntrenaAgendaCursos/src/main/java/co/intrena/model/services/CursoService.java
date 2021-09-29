package co.intrena.model.services;

import java.util.List;
import java.util.Optional;

import co.intrena.model.entity.Curso;

public interface CursoService {

	public List<Curso>findAll();//trae todos los registros de la tabla. Trae una lista.
	public Optional<Curso>findById(Integer Id); //Busca por Id. Trae un objeto del tipo Curso
	public Curso save(Curso curso);//Guarda en la b.d. el objeto curso
	public void deleteById(Integer Id);//Borra de la b.d. el objeto curso.
	
	
}
