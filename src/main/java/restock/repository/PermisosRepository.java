/*
 * 
 * Albert Codina
 */
package restock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import restock.entities.Permisos;

/**
 * The Interface PermisosRepository.
 */
public interface PermisosRepository extends JpaRepository<Permisos, Integer> {
	
	/**
	 * Find by rol id.
	 *
	 * @param rolId 
	 * @return list
	 */
	public List<Permisos> findByRolId(Integer rolId);
	

}
