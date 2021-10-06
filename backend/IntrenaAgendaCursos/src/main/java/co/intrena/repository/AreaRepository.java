package co.intrena.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.intrena.model.entity.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {

}
