/*
 * 
 * Albert Codina
 */
package restock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import restock.entities.Producte;


/**
 * The Interface ProducteRepository.
 */
public interface ProducteRepository extends JpaRepository<Producte, Integer> {
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return producte
	 */
	public Producte findById(Integer id);
	
	/**
	 * Find by proveidor id.
	 *
	 * @param provId the prov id
	 * @return list
	 */
	public List<Producte> findByProveidorId(Integer provId);
	
	/**
	 * Find by marca and model and subfamilia and proveidor.
	 *
	 * @param marca the marca
	 * @param model the model
	 * @param subfamiliaId the subfamilia id
	 * @param proveidorId the proveidor id
	 * @return producte
	 */
	@Query(value = " " +
			"SELECT prod "
			+ "FROM Producte prod WHERE "
			+ "prod.marca =:marca AND "
			+ "prod.model =:model AND "
			+ "prod.subfamilia.id =:subfamiliaId AND "
			+ "prod.proveidor.id =:proveidorId")
	public Producte findByMarcaAndModelAndSubfamiliaAndProveidor(
			@Param("marca") String marca,
			@Param("model") String model,
			@Param("subfamiliaId") Integer subfamiliaId,
			@Param("proveidorId") Integer proveidorId);
	

	/**
	 * Find by organitzacio id.
	 *
	 * @param orgId the org id
	 * @return list
	 */
	@Query(value = " " +
			"SELECT prod "
			+ "FROM Producte prod WHERE "
			+ "prod.proveidor.organitzacio.id =:orgId "
			+ "ORDER BY prod.marca ASC")
	public List<Producte> findByOrganitzacioId(
			@Param("orgId") Integer orgId);
	
	
	/**
	 * Cerca producte.
	 *
	 * @param camp the camp
	 * @param orgId the org id
	 * @return list
	 */
	@Query(value = " " +
			"SELECT prod "
			+ "FROM Producte prod WHERE "
			+ "(prod.model 		LIKE CONCAT('%',(:camp),'%') OR "
			+ "prod.marca 		LIKE CONCAT('%',(:camp),'%') OR "
			+ "prod.descripcio 	LIKE CONCAT('%',(:camp),'%')) AND "
			+ "prod.proveidor.organitzacio.id =:orgId "
			+ "ORDER BY prod.marca ASC")
	public List<Producte> cercaProducte(
			@Param("camp") String camp,
			@Param("orgId") Integer orgId);
}
