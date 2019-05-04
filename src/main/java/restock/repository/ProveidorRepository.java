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
	 * @param nif 
	 * @return proveidor
	 */
	public Proveidor findByNif(String nif);
	
	/**
	 * Find by nom.
	 *
	 * @param nom 
	 * @return proveidor
	 */
	public Proveidor findByNom(String nom);
	
	/**
	 * Find by id.
	 *
	 * @param id 	 
	 * @return proveidor
	 */
	public Proveidor findById(Integer id);

	/**
	 * Find by nom and organitzacio id.
	 *
	 * @param nom 
	 * @param organitzacioId
	 * @return proveidor
	 */
	public Proveidor findByNomAndOrganitzacioId(String nom, Integer organitzacioId);

	/**
	 * Find by organitzacio id.
	 *
	 * @param organitzacioId 
	 * @return list
	 */
	public List<Proveidor> findByOrganitzacioId(Integer organitzacioId);
	
	/**
	 * Cerca proveidor.
	 *
	 * @param camp 
	 * @param orgId 
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
