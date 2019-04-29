package restock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import restock.entities.Producte;


public interface ProducteRepository extends JpaRepository<Producte, Integer> {
	
	public Producte findById(Integer id);
	
	public List<Producte> findByProveidorId(Integer provId);
	
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
	

	@Query(value = " " +
			"SELECT prod "
			+ "FROM Producte prod WHERE "
			+ "prod.proveidor.organitzacio.id =:orgId "
			+ "ORDER BY prod.marca ASC")
	public List<Producte> findByOrganitzacioId(
			@Param("orgId") Integer orgId);
	
	
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
