package co.intrena.model.services;

import java.util.List;
import java.util.Optional;

import co.intrena.model.entity.Area;

public interface AreaService {
	
	public List<Area>findAll();
	public Optional<Area>findById(Integer id);
	public Area save(Area area);
	public void deleteById(Integer id);
	

}
