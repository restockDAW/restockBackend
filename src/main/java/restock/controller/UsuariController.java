/*
 * 
 * Albert Codina
 */
package restock.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;

import restock.entities.Usuari;
import restock.services.UsuariBusiness;


/**
 * The Class UsuariController.
 */
@RestController
@RequestMapping("/usuari")
public class UsuariController {
    
    @Autowired
    private UsuariBusiness usuariBusiness;

    /**
     * Usuari controller.
     */
    public UsuariController(){
    }

	@RequestMapping(path = "/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getUsuaris() {
		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final List<Usuari> usuaris = usuariBusiness.getResponsables();
			return new ResponseEntity<>(usuaris, httpHeaders, HttpStatus.OK);
		}catch(final Exception e){	
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NO_CONTENT);
		}
	}

	/**
	 * Gets usuaris de organitzacio.
	 *
	 * @param orgId the org id
	 * @return usuaris de organitzacio
	 */
	@RequestMapping(path = "/getResponsables", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getUsuarisDeOrganitzacio(
			@RequestBody final Integer orgId) {
		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final List<Usuari> usuaris = usuariBusiness.getResponsablesPerOrganitzacio(orgId);
			return new ResponseEntity<>(usuaris, httpHeaders, HttpStatus.OK);
		}catch(final Exception e){	
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NO_CONTENT);
		}
	}
	
	/**
	 * Gets usuari per id.
	 *
	 * @param userId the user id
	 * @return usuari per id
	 */
	@RequestMapping(path = "/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getUsuariPerId(@PathVariable final Integer userId) {
		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final Usuari usuariRetorn = usuariBusiness.getUserById(userId);
			if ((usuariRetorn == null)) {
				return new ResponseEntity<>("Aquest usuari no existeix", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(usuariRetorn, httpHeaders, HttpStatus.OK);
			}
		}catch(final Exception e){	
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NO_CONTENT);
		}
	}
    
	/**
	 * Alta.
	 *
	 * @param usuari the usuari
	 * @return response entity
	 */
	@RequestMapping(path = "/alta", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> alta(
			@RequestBody final Usuari usuari) {

		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final Usuari usuariRetorn = usuariBusiness.guardaUsuari(usuari);
			if ((usuariRetorn == null)) {
				return new ResponseEntity<>("El responsable ja existeix", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>("Responsable donat d'alta correctament", httpHeaders, HttpStatus.OK);
			}
		} catch (final Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	};
	
	/**
	 * Baixa.
	 *
	 * @param usuari the usuari
	 * @return response entity
	 */
	@RequestMapping(path = "/baixa", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> baixa(
			@RequestBody final Usuari usuari) {

		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final Usuari usuariRetorn = usuariBusiness.eliminaUsuari(usuari);
			if ((usuariRetorn == null)) {
				return new ResponseEntity<>("El responsable no es pot eliminar ja és un administrador", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>("Responsable donat de baixa correctament", httpHeaders, HttpStatus.OK);
			}
		} catch (final Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	};
	
	/**
	 * Modificacio.
	 *
	 * @param usuari the usuari
	 * @return response entity
	 */
	@RequestMapping(path = "/modificacio", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> modificacio(
			@RequestBody final Usuari usuari) {

		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final Usuari usuariRetorn = usuariBusiness.modificaUsuari(usuari);
			if ((usuariRetorn == null)) {
				return new ResponseEntity<>("No s’ha pogut modificar el responsable", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>("Responsable modificat correctament", httpHeaders, HttpStatus.OK);
			}
		} catch (final Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	};
	
	/**
	 * Gets usuaris.
	 *
	 * @param camp the camp
	 * @return usuaris
	 */
	@RequestMapping(path = "/cercar/{camp}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getUsuaris(@PathVariable final String camp) {
		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final List<Usuari> listUsuaris = usuariBusiness.cercarUsuari(camp);
			if ((listUsuaris.size()== 0)) {
				return new ResponseEntity<>("No s'han trobat resultats", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(listUsuaris, httpHeaders, HttpStatus.OK);
			}
		}catch(final Exception e){	
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NO_CONTENT);
		}
	}
}

