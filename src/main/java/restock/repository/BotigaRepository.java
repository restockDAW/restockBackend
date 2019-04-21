package restock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import restock.entities.Botiga;

public interface BotigaRepository extends JpaRepository<Botiga, Integer> {

	public Botiga findByNom(String nom);

	public Botiga findByNomAndOrganitzacioId(String nom, Integer organitzacioId);
	
	public List<Botiga> findByOrganitzacioId(Integer organitzacioId);

	public Botiga findById(Integer id);
	

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


