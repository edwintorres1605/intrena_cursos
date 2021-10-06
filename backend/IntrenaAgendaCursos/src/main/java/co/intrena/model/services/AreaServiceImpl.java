package co.intrena.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.intrena.model.entity.Area;
import co.intrena.repository.AreaRepository;


@Service
public class AreaServiceImpl implements AreaService {
	
	@Autowired
	private AreaRepository areaRepository;
	
	
	@Override
	public List<Area> findAll() {
		// TODO Auto-generated method stub
		return areaRepository.findAll();
	}

	@Override
	public Optional<Area> findById(Integer id) {
		// TODO Auto-generated method stub
		return areaRepository.findById(id);
	}

	@Override
	public Area save(Area area) {
		// TODO Auto-generated method stub
		return areaRepository.save(area);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		areaRepository.deleteById(id);
		
	}

}
