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

	
	/* (non-Javadoc)
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAll()
	 */
	public List<Usuari> findAll();
	
	/**
	 * Find by id.
	 *
	 * @param usuariId the usuari id
	 * @return usuari
	 */
	public Usuari findById(Integer usuariId);
	
	/**
	 * Find by user.
	 *
	 * @param user the user
	 * @return usuari
	 */
	public Usuari findByUser(String user);
	
	/**
	 * Find by user and password.
	 *
	 * @param user the user
	 * @param password the password
	 * @return  usuari
	 */
	public Usuari findByUserAndPassword(String user, String password);
	
	/**
	 * Find by user and nif and organitzacio id.
	 *
	 * @param user the user
	 * @param nif the nif
	 * @param organitacioId the organitacio id
	 * @return usuari
	 */
	public Usuari findByUserAndNifAndOrganitzacioId(String user, String nif, Integer organitacioId);

	/**
	 * Find by user and rol.
	 *
	 * @param user the user
	 * @param rol the rol
	 * @return usuari
	 */
	public Usuari findByUserAndRol(String user, Rol rol);
	
	/**
	 * Find by organitzacio id.
	 *
	 * @param OrgId the org id
	 * @return list
	 */
	public List<Usuari> findByOrganitzacioId(Integer OrgId);
	
	/**
	 * Find responsables of organitzacio.
	 *
	 * @param OrgId the org id
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
	 * @param camp the camp
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
	 * @param user the user
	 * @param organitzacioId the organitzacio id
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
