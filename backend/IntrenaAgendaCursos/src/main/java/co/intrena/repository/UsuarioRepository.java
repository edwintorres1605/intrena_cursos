package co.intrena.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.intrena.model.entity.Usuario;

@Repository

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
