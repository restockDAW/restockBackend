/*
 * 
 * Albert Codina
 */
package restock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import restock.entities.Familia;


/**
 * The Interface FamiliaRepository.
 */
public interface FamiliaRepository extends JpaRepository<Familia, Integer> {
	
	public List<Familia> findAll();
	
}
