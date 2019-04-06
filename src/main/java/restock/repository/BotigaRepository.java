package restock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import restock.entities.Botiga;

public interface BotigaRepository extends JpaRepository<Botiga, Integer> {

	public Botiga findByNom(String nom);

	public Botiga findByNomAndOrganitzacioId(String nom, Integer organitzacioId);
	
	public List<Botiga> findByOrganitzacioId(Integer organitzacioId);

	public Botiga findById(Integer id);
}
