/*
 * 
 * Albert Codina
 */
package restock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import restock.dto.Login;
import restock.entities.Usuari;
import restock.repository.UsuariRepository;

/**
 * The Class UsuariBusiness.
 */
@Component
public class UsuariBusiness {

	@Autowired
	private UsuariRepository usuariRepository;
	
	/**
	 * Login.
	 *
	 * @param login the login
	 * @return usuari
	 */
	public Usuari login(final Login login) {
		Usuari userExistent = usuariRepository.findByUserAndPassword(login.getUser(), login.getPassword());
		if(userExistent==null) {
			return null;
		}
		else {	
			return userExistent;
		}
	}

	public List<Usuari> getTotsElsUsuaris() {
		List<Usuari> Usuaris = usuariRepository.findAll();
		return Usuaris;
		}

	public List<Usuari> getResponsables() {
		List<Usuari> Usuaris = usuariRepository.findResponsables();
		return Usuaris;
		}
	
	/**
	 * Gets the usuaris per organitzacio.
	 *
	 * @param orgId the org id
	 * @return usuaris per organitzacio
	 */
	public List<Usuari> getUsuarisPerOrganitzacio(Integer orgId) {
		List<Usuari> usuaris = usuariRepository.findByOrganitzacioId(orgId);
		return usuaris;
		}
	
	/**
	 * Gets the responsables per organitzacio.
	 *
	 * @param orgId the org id
	 * @return responsables per organitzacio
	 */
	public List<Usuari> getResponsablesPerOrganitzacio(Integer orgId) {
		List<Usuari> usuaris = usuariRepository.findResponsablesOfOrganitzacio(orgId);
		return usuaris;
	}
	
	
	/**
	 * Gets the user by id.
	 *
	 * @param usuariId the usuari id
	 * @return the user by id
	 */
	public Usuari getUserById(final Integer usuariId) {
		Usuari userExistent = usuariRepository.getOne(usuariId);

		if(userExistent==null) {
			return null;
		}else {
			return userExistent;
		}
	}
	

	/**
	 * Guarda usuari.
	 *
	 * @param usuari the usuari
	 * @return usuari
	 */
	public Usuari guardaUsuari(final Usuari usuari) {
		Usuari userExistent = usuariRepository.findByUser(usuari.getUser());
		
		//No existeix usuari es dona d'alta.
		if(userExistent==null) {
			usuariRepository.save(usuari);
			return usuari;
		}else {
			return null;
		}
	}
	
	/**
	 * Elimina usuari.
	 *
	 * @param usuari the usuari
	 * @return usuari
	 */
	public Usuari eliminaUsuari(final Usuari usuari) {
		Usuari userExistent = usuariRepository.findByUserAndRol(usuari.getUser(), usuari.getRol());
		
		//Si usuari no es administrador es podra donar de baixa.
		if(userExistent!=null && usuari.getRol().getId()==2) {
			usuariRepository.delete(userExistent);
			return usuari;
		}else {
			return null;
		}
	}
	
	/**
	 * Modifica usuari.
	 *
	 * @param usuari the usuari
	 * @return usuari
	 */
	public Usuari modificaUsuari(final Usuari usuari) {
		Usuari userExistent = usuariRepository.findByUser(usuari.getUser());
		
		//Si no existeix usuari no es pot modificar.
		if(userExistent!=null) {
			userExistent.setNom(usuari.getNom());
			userExistent.setCognom1(usuari.getCognom1());
			userExistent.setCognom2(usuari.getCognom2());
			userExistent.setCorreu(usuari.getCorreu());
			userExistent.setDataNaixement(usuari.getDataNaixement());
			userExistent.setNif(usuari.getNif());
			usuariRepository.save(userExistent);
			return usuari;
		}else {
			return null;
		}
	}
	
	/**
	 * Cercar usuari.
	 *
	 * @param camp the camp
	 * @return list
	 */
	public List<Usuari> cercarUsuari(final String camp) {
		List<Usuari> llistaUsuaris = null;
		llistaUsuaris = usuariRepository.cercaUsuari(camp);
		
		if(llistaUsuaris!=null) {
			
			return llistaUsuaris;
		}else {
			return null;
		}
	}
}