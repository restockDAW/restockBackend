/*
 * 
 * Albert Codina
 */
package restock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import restock.dto.Cercador;
import restock.entities.Familia;
import restock.entities.Producte;
import restock.entities.SubFamilia;
import restock.repository.FamiliaRepository;
import restock.repository.ProducteRepository;
import restock.repository.SubfamiliaRepository;

/**
 * The Class ProducteBusiness.
 */
@Component
public class ProducteBusiness {

	
	@Autowired
	private ProducteRepository producteRepository;	
	
	@Autowired
	private FamiliaRepository familiaRepository;
	
	@Autowired
	private SubfamiliaRepository subfamiliaRepository;

	/**
	 * Guarda producte.
	 *
	 * @param producte the producte
	 * @return producte
	 */
	public Producte guardaProducte(final Producte producte) {
		Producte producteExistent= producteRepository.findByMarcaAndModelAndSubfamiliaAndProveidor(producte.getMarca(), producte.getModel(),
				producte.getSubfamilia().getId(), producte.getProveidor().getId());
				
		//No existeix el producte es dona d'alta.
		if(producteExistent == null) {
			producteRepository.save(producte);
			return producte;
		//El producte ja existeix.
		}else return null;	
	}
	
	
	/**
	 * Elimina producte.
	 *
	 * @param producte the producte
	 * @return producte
	 */
	public Producte eliminaProducte(final Producte producte) {
		Producte producteExistent = producteRepository.findById(producte.getId());
		
		//Si el producte existeix es podra donar de baixa.
		if(producteExistent!=null) {
			producteRepository.delete(producteExistent);
			return producte;
		}else {
			return null;
		}
	}
	
	/**
	 * Modifica producte.
	 *
	 * @param producte the producte
	 * @return producte
	 */
	public Producte modificaProducte(final Producte producte) {
		Producte producteExistent = producteRepository.findById(producte.getId());
		
		//Si no existeix producte no es pot modificar.
		if(producteExistent!=null) {
			producteExistent.setMarca(producte.getMarca());
			producteExistent.setModel(producte.getModel());
			producteExistent.setDescripcio(producte.getDescripcio());
			producteExistent.setPreu(producte.getPreu());
			producteExistent.setPreuVenda(producte.getPreuVenda());
			producteExistent.setSubfamilia(producte.getSubfamilia());
			producteExistent.setProveidor(producte.getProveidor());
			producteRepository.save(producteExistent);
		
			return producte;
		}else {
			return null;
		}
	}
	
	/**
	 * Gets the productes per proveidor.
	 *
	 * @param provId the prov id
	 * @return productes per proveidor
	 */
	public List<Producte> getProductesPerProveidor(Integer provId) {
		List<Producte> productes = producteRepository.findByProveidorId(provId);
		return productes;
	}
	
	public List<Familia> getFamilies() {
		List<Familia> families = familiaRepository.findAll();
		return families;
	}
	
	/**
	 * Gets the subfamilia per familia.
	 *
	 * @param famId the fam id
	 * @return subfamilia per familia
	 */
	public List<SubFamilia> getSubfamiliaPerFamilia(Integer famId) {
		List<SubFamilia> subfamilies = subfamiliaRepository.findByFamiliaId(famId);
		return subfamilies;
	}
	
	/**
	 * Cercar producte.
	 *
	 * @param cercadorProducte the cercador producte
	 * @return list
	 */
	public List<Producte> cercarProducte(final Cercador cercadorProducte) {
		List<Producte> llistaProductes = null;
		String camp = cercadorProducte.getCamp();
		Integer orgId = cercadorProducte.getOrgId();
		llistaProductes = producteRepository.cercaProducte(camp, orgId );
		
		if(llistaProductes!=null) {
			
			return llistaProductes;
		}else {
			return null;
		}
	}
	

	/**
	 * Gets the productes per organitzacio.
	 *
	 * @param orgId the org id
	 * @return productes per organitzacio
	 */
	public List<Producte> getProductesPerOrganitzacio(Integer orgId) {
		List<Producte> productes = producteRepository.findByOrganitzacioId(orgId);
		return productes;
		}
	
	
}