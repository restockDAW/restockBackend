package restock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import restock.entities.Rol;
import restock.entities.Usuari;
import java.util.List;

public interface UsuariRepository extends JpaRepository<Usuari, Integer> {

	public List<Usuari> findAll();
	
	public Usuari findById(Integer usuariId);
	
	public Usuari findByUser(String user);
	
	public Usuari findByUserAndPassword(String user, String password);
	
	public Usuari findByUserAndNifAndOrganitzacioId(String user, String nif, Integer organitacioId);

	public Usuari findByUserAndRol(String user, Rol rol);
	
	public List<Usuari> findByOrganitzacioId(Integer OrgId);
	
	@Query(value = " " +
			"SELECT usu "
			+ "FROM Usuari usu WHERE "
			+ "(usu.rol.id = 2 AND "
			+ "usu.organitzacio.id =:organitzacioId )")
	public List<Usuari> findResponsablesOfOrganitzacio(@Param("organitzacioId") Integer OrgId);

	@Query(value = " " +
			"SELECT usu "
			+ "FROM Usuari usu WHERE "
			+ "(usu.rol.id = 2)")
	public List<Usuari> findResponsables();
	

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
	
	@Query(value = " " +
			"SELECT usu "
			+ "FROM Usuari usu WHERE "
			+ "(usu.user =:user AND "
			+ "usu.organitzacio.id =:organitzacioId )")
	public Usuari findByUserAndOrganitzacioId(@Param("user") String user, 
			@Param("organitzacioId") Integer organitzacioId);

	
	
	
}
