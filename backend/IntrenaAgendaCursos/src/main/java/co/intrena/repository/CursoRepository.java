package co.intrena.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.intrena.model.entity.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{

}
