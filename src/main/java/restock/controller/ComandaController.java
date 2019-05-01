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
import restock.entities.Organitzacio;
import restock.services.ComandaBusiness;


@RestController
@RequestMapping("/comanda")
public class ComandaController {
    
    @Autowired
    private ComandaBusiness comandaBusiness;
    

    public ComandaController(){
    }
 
	
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
}

