package co.intrena.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.intrena.model.entity.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Integer>{

}
