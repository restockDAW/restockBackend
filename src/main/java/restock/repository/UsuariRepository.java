package restock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import restock.entities.Rol;
import restock.entities.Usuari;

public interface UsuariRepository extends JpaRepository<Usuari, Integer> {
	
	public Usuari findById(Integer usuariId);
	
	public Usuari findByUser(String user);
	
	public Usuari findByUserAndPassword(String user, String password);
	
	public Usuari findByUserAndRol(String user, Rol rol);


}
