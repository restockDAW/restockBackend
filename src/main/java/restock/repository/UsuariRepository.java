/*
 * 
 * Albert Codina
 */
package restock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import restock.entities.Rol;
import restock.entities.Usuari;
import java.util.List;

/**
 * The Interface UsuariRepository.
 */
public interface UsuariRepository extends JpaRepository<Usuari, Integer> {

	
	public List<Usuari> findAll();
	
	/**
	 * Find by id.
	 *
	 * @param usuariId 
	 * @return usuari
	 */
	public Usuari findById(Integer usuariId);
	
	/**
	 * Find by user.
	 *
	 * @param user 
	 * @return usuari
	 */
	public Usuari findByUser(String user);
	
	/**
	 * Find by user and password.
	 *
	 * @param user 
	 * @param password
	 * @return  usuari
	 */
	public Usuari findByUserAndPassword(String user, String password);
	
	/**
	 * Find by user and nif and organitzacio id.
	 *
	 * @param user 
	 * @param nif 
	 * @param organitacioId
	 * @return usuari
	 */
	public Usuari findByUserAndNifAndOrganitzacioId(String user, String nif, Integer organitacioId);

	/**
	 * Find by user and rol.
	 *
	 * @param user 
	 * @param rol
	 * @return usuari
	 */
	public Usuari findByUserAndRol(String user, Rol rol);
	
	/**
	 * Find by organitzacio id.
	 *
	 * @param OrgId 
	 * @return list
	 */
	public List<Usuari> findByOrganitzacioId(Integer OrgId);
	
	/**
	 * Find responsables of organitzacio.
	 *
	 * @param OrgId
	 * @return list
	 */
	@Query(value = " " +
			"SELECT usu "
			+ "FROM Usuari usu WHERE "
			+ "(usu.rol.id = 2 AND "
			+ "usu.organitzacio.id =:organitzacioId )")
	public List<Usuari> findResponsablesOfOrganitzacio(@Param("organitzacioId") Integer OrgId);

	/**
	 * Find responsables.
	 *
	 * @return list
	 */
	@Query(value = " " +
			"SELECT usu "
			+ "FROM Usuari usu WHERE "
			+ "(usu.rol.id = 2)")
	public List<Usuari> findResponsables();
	

	/**
	 * Cerca usuari.
	 *
	 * @param camp 
	 * @return list
	 */
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
	
	/**
	 * Find by user and organitzacio id.
	 *
	 * @param user 
	 * @param organitzacioId 
	 * @return usuari
	 */
	@Query(value = " " +
			"SELECT usu "
			+ "FROM Usuari usu WHERE "
			+ "(usu.user =:user AND "
			+ "usu.organitzacio.id =:organitzacioId )")
	public Usuari findByUserAndOrganitzacioId(@Param("user") String user, 
			@Param("organitzacioId") Integer organitzacioId);

	
	
	
}
