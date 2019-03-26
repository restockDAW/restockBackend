package restock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import restock.entities.Rol;
import restock.entities.Usuari;

public interface UsuariRepository extends JpaRepository<Usuari, Integer> {
	
	public Usuari findById(Integer usuariId);
	
	public Usuari findByUser(String user);
	
	public Usuari findByUserAndPassword(String user, String password);
	
	public Usuari findByUserAndRol(String user, Rol rol);
		
	@Query(value = " " +
			"SELECT usu "
			+ "FROM Usuari usu WHERE "
			+ "(usu.nom 	LIKE CONCAT('%',(:camp),'%') OR "
			+ "usu.cognom1 	LIKE CONCAT('%',(:camp),'%') OR "
			+ "usu.cognom2 	LIKE CONCAT('%',(:camp),'%') OR "
			+ "usu.nif 		LIKE CONCAT('%',(:camp),'%')) AND "
			+ "usu.rol.id = 2 "
			+ "ORDER BY usu.nom ASC")
	public List<Usuari> cercaUsuari(@Param("camp") String camp);


}
