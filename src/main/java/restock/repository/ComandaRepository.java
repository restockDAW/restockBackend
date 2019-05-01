package restock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import restock.entities.Comanda;

public interface ComandaRepository extends JpaRepository<Comanda, Integer> {
	public List<Comanda> findByBotigaId(Integer botigaId);
	

}
