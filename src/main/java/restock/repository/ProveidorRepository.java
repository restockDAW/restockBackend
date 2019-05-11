/*
 * 
 * Albert Codina
 */
package restock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import restock.entities.Proveidor;

/**
 * The Interface ProveidorRepository.
 */
public interface ProveidorRepository extends JpaRepository<Proveidor, Integer> {

	/**
	 * Find by nif.
	 *
	 * @param nif the nif
	 * @return proveidor
	 */
	public Proveidor findByNif(String nif);
	
	/**
	 * Find by nom.
	 *
	 * @param nom the nom
	 * @return proveidor
	 */
	public Proveidor findByNom(String nom);
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return proveidor
	 */
	public Proveidor findById(Integer id);

	/**
	 * Find by nom and organitzacio id.
	 *
	 * @param nom the nom
	 * @param organitzacioId the organitzacio id
	 * @return proveidor
	 */
	public Proveidor findByNomAndOrganitzacioId(String nom, Integer organitzacioId);

	/**
	 * Find by organitzacio id.
	 *
	 * @param organitzacioId the organitzacio id
	 * @return list
	 */
	public List<Proveidor> findByOrganitzacioId(Integer organitzacioId);
	
	/**
	 * Cerca proveidor.
	 *
	 * @param camp the camp
	 * @param orgId the org id
	 * @return list
	 */
	@Query(value = " " +
			"SELECT prov "
			+ "FROM Proveidor prov WHERE "
			+ "(prov.nom 		LIKE CONCAT('%',(:camp),'%') OR "
			+ "prov.nif 		LIKE CONCAT('%',(:camp),'%') OR "
			+ "prov.poblacio	LIKE CONCAT('%',(:camp),'%')) AND "
			+ "prov.organitzacio.id =:orgId "
			+ "ORDER BY prov.nom ASC")
	public List<Proveidor> cercaProveidor(
			@Param("camp") String camp,
			@Param("orgId") Integer orgId);
}
