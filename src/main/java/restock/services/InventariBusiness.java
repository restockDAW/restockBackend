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

@Component
public class InventariBusiness {
	@Autowired
	private InventariRepository inventariRepository;
	
	@Autowired
	private BotigaRepository botigaRepository;

	
	public List<Inventari> cercaInventariPerBotiga(final Botiga botiga) {
		
		List<Inventari> inventaris = new ArrayList<Inventari>();
		inventaris = inventariRepository.findByBotigaId(botiga.getId());
		if(inventaris.size()>0) {
			return inventaris;
		}else return null;
				
	}
	
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
