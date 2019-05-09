/*
 * 
 * Albert Codina
 */
package restock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import restock.entities.Inventari;

/**
 * The Interface InventariRepository.
 */
public interface InventariRepository extends JpaRepository<Inventari, Integer> {
	
	/**
	 * Find by botiga id.
	 *
	 * @param botigaId
	 * @return list
	 */
	public List<Inventari> findByBotigaId(Integer botigaId);
	
	public Inventari findByBotigaIdAndProducteId(Integer botigaId, Integer producteId);
}
