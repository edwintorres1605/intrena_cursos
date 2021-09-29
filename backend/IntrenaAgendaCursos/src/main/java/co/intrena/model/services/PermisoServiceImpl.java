package co.intrena.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.intrena.model.entity.Permiso;
import co.intrena.repository.PermisoRepository;

@Service
public class PermisoServiceImpl implements PermisoService{
	@Autowired
	private PermisoRepository permisoRepository;
	
	@Override
	public List<Permiso> findAll(){
		return permisoRepository.findAll();	
	}
	
	@Override
	public Optional<Permiso> findById(Integer Id) {
		return permisoRepository.findById(Id);	
	}
	
	@Override
	public Permiso save(Permiso permiso) {
		return permisoRepository.save(permiso);
	}
	@Override
	public void deleteById(Integer Id) {
		// TODO Auto-generated method stub
		permisoRepository.deleteById(Id);
	}
	
}
