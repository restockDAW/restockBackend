package restock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import restock.entities.Inventari;

public interface InventariRepository extends JpaRepository<Inventari, Integer> {
	public List<Inventari> findByBotigaId(Integer botigaId);
	

}
