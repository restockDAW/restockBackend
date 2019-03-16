package restock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import restock.entities.Usuari;

public interface UsuariRepository extends JpaRepository<Usuari, Integer> {
	
	public Usuari findById(Integer usuariId);
	
	public Usuari findByUser(String user);

}
