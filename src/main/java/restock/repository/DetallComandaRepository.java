/*
 * 
 * Albert Codina
 */
package restock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import restock.entities.DetallComanda;

/**
 * The Interface DetallComandaRepository.
 */
public interface DetallComandaRepository extends JpaRepository<DetallComanda, Integer> {

	/**
	 * Find by comanda id.
	 *
	 * @param comandaId the comanda id
	 * @return list
	 */
	public List<DetallComanda> findByComandaId(Integer comandaId);
}
