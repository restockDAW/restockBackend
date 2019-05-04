/*
 * 
 * Albert Codina
 */
package restock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import restock.entities.Botiga;

/**
 * The Interface BotigaRepository.
 */
public interface BotigaRepository extends JpaRepository<Botiga, Integer> {

	/**
	 * Find by nom.
	 *
	 * @param nom 
	 * @return botiga
	 */
	public Botiga findByNom(String nom);

	/**
	 * Find by nom and organitzacio id.
	 *
	 * @param nom 
	 * @param organitzacioId
	 * @return botiga
	 */
	public Botiga findByNomAndOrganitzacioId(String nom, Integer organitzacioId);
	
	/**
	 * Find by organitzacio id.
	 *
	 * @param organitzacioId 
	 * @return list
	 */
	public List<Botiga> findByOrganitzacioId(Integer organitzacioId);

	/**
	 * Find by id.
	 *
	 * @param id
	 * @return botiga
	 */
	public Botiga findById(Integer id);
	

	/**
	 * Cerca botiga.
	 *
	 * @param camp 
	 * @param orgId
	 * @return list
	 */
	@Query(value = " " +
			"SELECT bot "
			+ "FROM Botiga bot WHERE "
			+ "(bot.nom 	LIKE CONCAT('%',(:camp),'%') OR "
			+ "bot.poblacio	LIKE CONCAT('%',(:camp),'%')) AND "
			+ "bot.organitzacio.id =:orgId "
			+ "ORDER BY bot.nom ASC")
	public List<Botiga> cercaBotiga(
			@Param("camp") String camp,
			@Param("orgId") Integer orgId);
}


