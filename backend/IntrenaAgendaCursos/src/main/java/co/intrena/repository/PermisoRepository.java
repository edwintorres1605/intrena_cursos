package co.intrena.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.intrena.model.entity.Permiso;

@Repository
public interface PermisoRepository extends  JpaRepository<Permiso, Integer> {

}
