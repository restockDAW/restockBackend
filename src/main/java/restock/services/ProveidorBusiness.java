/*
 * 
 * Albert Codina
 */
package restock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import restock.dto.Cercador;
import restock.entities.Proveidor;
import restock.repository.ProveidorRepository;

/**
 * The Class ProveidorBusiness.
 */
@Component
public class ProveidorBusiness {

	
	@Autowired
	private ProveidorRepository proveidorRepository;

	/**
	 * Guarda proveidor.
	 *
	 * @param proveidor the proveidor
	 * @return proveidor
	 */
	public Proveidor guardaProveidor(final Proveidor proveidor) {
		Proveidor proveidorExistent= proveidorRepository.findByNomAndOrganitzacioId(proveidor.getNom(), proveidor.getOrganitzacio().getId());
				
		//No existeix el proveidor es dona d'alta.
		if(proveidorExistent == null) {
			proveidorRepository.save(proveidor);
			return proveidor;
			//El proveidor ja existeix.
		}else return null;	
	}
	
	
	/**
	 * Elimina proveidor.
	 *
	 * @param proveidor the proveidor
	 * @return proveidor
	 */
	public Proveidor eliminaProveidor(final Proveidor proveidor) {
		Proveidor proveidorExistent = proveidorRepository.findById(proveidor.getId());
		
		//Si el proveidor existeix es podra donar de baixa.
		if(proveidorExistent!=null) {
			proveidorRepository.delete(proveidorExistent);
			return proveidor;
		}else {
			return null;
		}
	}
	
	/**
	 * Modifica proveidor.
	 *
	 * @param proveidor the proveidor
	 * @return proveidor
	 */
	public Proveidor modificaProveidor(final Proveidor proveidor) {
		Proveidor proveidorExistent = proveidorRepository.findById(proveidor.getId());
		
		//Si no existeix proveidor no es pot modificar.
		if(proveidorExistent!=null) {

			proveidorExistent.setNif(proveidor.getNif());
			proveidorExistent.setNom(proveidor.getNom());
			proveidorExistent.setCarrer(proveidor.getCarrer());
			proveidorExistent.setCodiPostal(proveidor.getCodiPostal());
			proveidorExistent.setNumero(proveidor.getNumero());
			proveidorExistent.setOrganitzacio(proveidor.getOrganitzacio());
			proveidorExistent.setPais(proveidor.getPais());
			proveidorExistent.setPlasEntrega(proveidor.getPlasEntrega());
			proveidorExistent.setPoblacio(proveidor.getPoblacio());
			//proveidorExistent.setOrganitzacio(proveidor.getOrganitzacio());
			proveidorRepository.save(proveidorExistent);
		
			return proveidor;
		}else {
			return null;
		}
	}
	
	/**
	 * Gets the proveidors per organitzacio.
	 *
	 * @param orgId the org id
	 * @return proveidors per organitzacio
	 */
	public List<Proveidor> getProveidorsPerOrganitzacio(Integer orgId) {
		List<Proveidor> proveidors = proveidorRepository.findByOrganitzacioId(orgId);
		return proveidors;
		}
	
	
	
	/**
	 * Cercar proveidor.
	 *
	 * @param cercadorProveidor the cercador proveidor
	 * @return list
	 */
	public List<Proveidor> cercarProveidor(final Cercador cercadorProveidor) {
		List<Proveidor> llistaProveidors = null;
		String camp = cercadorProveidor.getCamp();
		Integer orgId = cercadorProveidor.getOrgId();
		llistaProveidors = proveidorRepository.cercaProveidor(camp, orgId );
		
		if(llistaProveidors!=null) {
			
			return llistaProveidors;
		}else {
			return null;
		}
	}
}
