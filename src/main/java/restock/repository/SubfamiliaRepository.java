/*
 * 
 * Albert Codina
 */
package restock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import restock.entities.SubFamilia;


/**
 * The Interface SubfamiliaRepository.
 */
public interface SubfamiliaRepository extends JpaRepository<SubFamilia, Integer> {
	
	/**
	 * Find by familia id.
	 *
	 * @param famId the fam id
	 * @return list
	 */
	public List<SubFamilia> findByFamiliaId(Integer famId);
	
}
