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
import restock.entities.Comanda;
import restock.entities.DetallComanda;
import restock.entities.Organitzacio;
import restock.services.ComandaBusiness;
import restock.services.DetallComandaBusiness;


/**
 * The Class ComandaController.
 */
@RestController
@RequestMapping("/comanda")
public class ComandaController {
    
    @Autowired
    private ComandaBusiness comandaBusiness;
    
    @Autowired
    private DetallComandaBusiness detallComandaBusiness;
    

    /**
     * Comanda controller.
     */
    public ComandaController(){
    }
 
	
	/**
	 * Alta.
	 *
	 * @param comandaBotiga 
	 * @return response entity
	 */
	@RequestMapping(path = "/alta", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> alta(
			@RequestBody final ComandaBotiga comandaBotiga) {

		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final Comanda comandaRetorn = comandaBusiness.guardaComanda(comandaBotiga);
			if ((comandaRetorn == null)) {
				return new ResponseEntity<>("No s'ha pogut donar d'alta la comanda", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>("Comanda enviada correctament", httpHeaders, HttpStatus.OK);
			}
		} catch (final Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
//	@RequestMapping(path = "/modificacio", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<?> modificacio(
//			@RequestBody final Proveidor proveidor) {
//
//		try {
//			final HttpHeaders httpHeaders = new HttpHeaders();
//			final Proveidor proveidorRetorn = proveidorBusiness.modificaProveidor(proveidor);
//			if ((proveidorRetorn == null)) {
//				return new ResponseEntity<>("No s’ha pogut modificar el proveidor", httpHeaders, HttpStatus.BAD_REQUEST);
//			} else {
//				return new ResponseEntity<>("Proveidor modificat correctament", httpHeaders, HttpStatus.OK);
//			}
//		} catch (final Exception e) {
//			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//		}
//	}
	
	
	/**
 * Gets the comandes per botiga.
 *
 * @param botiga 
 * @return comandes per botiga
 */
@RequestMapping(path = "/cercarPerBotiga", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getComandesPerBotiga(
			@RequestBody final Botiga botiga) {

		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final List<Comanda> listComandes = comandaBusiness.cercaComandesPerBotiga(botiga);
			if ((listComandes.size()== 0)) {
				return new ResponseEntity<>("No s'han trobat comandes", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(listComandes, httpHeaders, HttpStatus.OK);
			}
		} catch (final Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Gets comandes pendents per botiga.
	 *
	 * @param botiga 
	 * @return comandes pendents per botiga
	 */
	@RequestMapping(path = "/cercarPendentsPerBotiga", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getComandesPendentsPerBotiga(
			@RequestBody final Botiga botiga) {

		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final List<Comanda> listComandes = comandaBusiness.cercaComandesPendentsPerBotiga(botiga);
			if (listComandes == null) {
				return new ResponseEntity<>("No s'han trobat comandes pendents de rebre", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(listComandes, httpHeaders, HttpStatus.OK);
			}
		} catch (final Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Gets comandes per organitzacio.
	 *
	 * @param org 
	 * @return comandes per organitzacio
	 */
	@RequestMapping(path = "/cercarPerOrganitzacio", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getComandesPerOrganitzacio(
			@RequestBody final Organitzacio org) {

		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final List<Comanda> listComandes = comandaBusiness.cercaComandesPerOrganitzacio(org);
			if ((listComandes.size()== 0)) {
				return new ResponseEntity<>("No s'han trobat comandes", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(listComandes, httpHeaders, HttpStatus.OK);
			}
		} catch (final Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Gets comandes pendents per organitzacio.
	 *
	 * @param org
	 * @return comandes pendents per organitzacio
	 */
	@RequestMapping(path = "/cercarPendentsPerOrganitzacio", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getComandesPendentsPerOrganitzacio(
			@RequestBody final Organitzacio org) {

		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final List<Comanda> listComandes = comandaBusiness.cercaComandesPendentsPerOrganitzacio(org);
			if (listComandes == null) {
				return new ResponseEntity<>("No s'han trobat comandes pendents", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(listComandes, httpHeaders, HttpStatus.OK);
			}
		} catch (final Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Veure detall comanda.
	 *
	 * @param comanda 
	 * @return response entity
	 */
	@RequestMapping(path = "/veureDetallComanda", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> veureDetallComanda(
			@RequestBody final Comanda comanda) {

		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final List<DetallComanda> listDetallComanda = detallComandaBusiness.cercaDetallComanda(comanda);
			if ((listDetallComanda.size()== 0)) {
				return new ResponseEntity<>("No s'ha trobat el detall de la comanda", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(listDetallComanda, httpHeaders, HttpStatus.OK);
			}
		} catch (final Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}

