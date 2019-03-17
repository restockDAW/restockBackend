package restock.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import restock.dto.Login;
import restock.entities.Organitzacio;
import restock.entities.Usuari;
import restock.repository.OrganitzacioRepository;
import restock.repository.UsuariRepository;

@Component
public class UsuarisBusiness {

	@Autowired
	private UsuariRepository usuariRepository;
	
	@Autowired
	private OrganitzacioRepository organitzacioRepository;

	public Organitzacio guardaAdministrador(final Organitzacio organitzacio) {
		Usuari userExistent = usuariRepository.findByUser(organitzacio.getUsuari().getUser());
		Organitzacio organitzacioExistent= organitzacioRepository.findByNom(organitzacio.getNom());
		//No existeix ni administrador ni organització i es donen d'alta els dos.
		if(userExistent==null && organitzacioExistent == null) {
			usuariRepository.save(organitzacio.getUsuari());
			organitzacioRepository.save(organitzacio);
			return organitzacio;
		}
		//La organització no existex pero ja existeix un usuari administrador previ. Es dona d'alta organitzacio
		else if (userExistent!=null && organitzacioExistent == null) {
			organitzacioRepository.save(organitzacio);
			return organitzacio;
		}
		//La organització ja existeix pero té un altre administrador.
		//No es dona d'alta res, ja que no es pot canviar administrador d'una organitzacio existent
		else if (userExistent==null && organitzacioExistent != null) {
			return null;
		}else return null;
	}
	
	public Usuari login(final Login login) {
		Usuari userExistent = usuariRepository.findByUserAndPassword(login.getUser(), login.getPassword());
		if(userExistent==null) {
			return null;
		}
		else {	
			return userExistent;
		}
	}
}