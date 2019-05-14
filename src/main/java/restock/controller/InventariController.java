/*
 * 
 * Albert Codina
 */
package restock.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;

import restock.dto.ComandaBotiga;
import restock.entities.Botiga;
import restock.entities.Inventari;
import restock.entities.Organitzacio;
import restock.services.ComandaBusiness;
import restock.services.InventariBusiness;


/**
 * The Class InventariController.
 */
@RestController
@RequestMapping("/inventari")
public class InventariController {
    
    @Autowired
    private InventariBusiness inventariBusiness;
    @Autowired
    private ComandaBusiness comandaBusiness;
    

    /**
     * Inventari controller.
     */
    public InventariController(){
    }
 
	
	/**
	 * Gets comandes per botiga.
	 *
	 * @param botiga 
	 * @return inventari per botiga
	 */
	@RequestMapping(path = "/cercarPerBotiga", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getComandesPerBotiga(
			@RequestBody final Botiga botiga) {

		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final List<Inventari> listInventari = inventariBusiness.cercaInventariPerBotiga(botiga);
			if ((listInventari.size()== 0)) {
				return new ResponseEntity<>("No s'ha trobat inventari", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(listInventari, httpHeaders, HttpStatus.OK);
			}
		} catch (final Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Gets comandes per organitzacio.
	 *
	 * @param org 
	 * @return inventari per organitzacio
	 */
	@RequestMapping(path = "/cercarPerOrganitzacio", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getComandesPerOrganitzacio(
			@RequestBody final Organitzacio org) {

		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final List<Inventari> listInventari = inventariBusiness.cercaInventariPerOrganitzacio(org);
			if ((listInventari.size()== 0)) {
				return new ResponseEntity<>("No s'han trobat inventari", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(listInventari, httpHeaders, HttpStatus.OK);
			}
		} catch (final Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Actualitzar inventari al rebre comanda.
	 *
	 * @param comandaBotiga
	 * @return inventari per botiga
	 */
	@RequestMapping(path = "/actualitzarInventari", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> actualitzarInventari(
			@RequestBody final ComandaBotiga comandaBotiga) {

		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final List<Inventari> listInventari = inventariBusiness.actualitzarInventari(comandaBotiga);
			if ((listInventari.size()== 0)) {
				return new ResponseEntity<>("No s'ha pogut actualitzar l'inventari", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				comandaBusiness.eliminaComanda(comandaBotiga);
				return new ResponseEntity<>(listInventari, httpHeaders, HttpStatus.OK);
			}
		} catch (final Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}

