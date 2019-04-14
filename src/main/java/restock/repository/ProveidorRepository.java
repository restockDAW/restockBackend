package restock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import restock.entities.Proveidor;

public interface ProveidorRepository extends JpaRepository<Proveidor, Integer> {

	public Proveidor findByNif(String nif);
	
	public Proveidor findByNom(String nom);
	
	public Proveidor findById(Integer id);

	public Proveidor findByNomAndOrganitzacioId(String nom, Integer organitzacioId);

	public List<Proveidor> findByOrganitzacioId(Integer organitzacioId);
}
