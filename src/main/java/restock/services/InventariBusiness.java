/*
 * 
 * Albert Codina
 */
package restock.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import restock.entities.Botiga;
import restock.entities.Inventari;
import restock.entities.Organitzacio;
import restock.repository.BotigaRepository;
import restock.repository.InventariRepository;

/**
 * The Class InventariBusiness.
 */
@Component
public class InventariBusiness {
	@Autowired
	private InventariRepository inventariRepository;
	
	@Autowired
	private BotigaRepository botigaRepository;

	
	/**
	 * Cerca inventari per botiga.
	 *
	 * @param botiga
	 * @return list
	 */
	public List<Inventari> cercaInventariPerBotiga(final Botiga botiga) {
		
		List<Inventari> inventaris = new ArrayList<Inventari>();
		inventaris = inventariRepository.findByBotigaId(botiga.getId());
		if(inventaris.size()>0) {
			return inventaris;
		}else return null;
				
	}
	
	/**
	 * Cerca inventari per organitzacio.
	 *
	 * @param org
	 * @return list
	 */
	public List<Inventari> cercaInventariPerOrganitzacio(final Organitzacio org) {
		
		List<Botiga> botigues = new ArrayList<Botiga>();
		botigues = botigaRepository.findByOrganitzacioId(org.getId());

		List<Inventari> inventaris = new ArrayList<Inventari>();
		
		if(botigues.size()>0) {
			for(Botiga botiga : botigues) {
				List<Inventari> inventariPerBotiga = inventariRepository.findByBotigaId(botiga.getId());
				inventaris.addAll(inventariPerBotiga);
			}
		}
		if(inventaris.size()>0) {
			return inventaris;
		}else return null;
				
	}
	
}
