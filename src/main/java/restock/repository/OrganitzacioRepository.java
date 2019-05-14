/*
 * 
 * Albert Codina
 */
package restock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import restock.entities.Organitzacio;

/**
 * The Interface OrganitzacioRepository.
 */
public interface OrganitzacioRepository extends JpaRepository<Organitzacio, Integer> {

	/**
	 * Find by nif.
	 *
	 * @param nif the nif
	 * @return organitzacio
	 */
	public Organitzacio findByNif(String nif);
	
	/**
	 * Find by nom.
	 *
	 * @param nom the nom
	 * @return organitzacio
	 */
	public Organitzacio findByNom(String nom);

	public Organitzacio findByUsuariId(Integer id);
	
	
}
