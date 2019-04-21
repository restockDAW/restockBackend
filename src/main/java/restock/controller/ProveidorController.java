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

import restock.dto.Cercador;
import restock.entities.Proveidor;
import restock.services.ProveidorBusiness;


@RestController
@RequestMapping("/proveidor")
public class ProveidorController {
    
    @Autowired
    private ProveidorBusiness proveidorBusiness;
    

    public ProveidorController(){
    }
 
    
	@RequestMapping(path = "/alta", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> alta(
			@RequestBody final Proveidor proveidor) {

		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final Proveidor proveidorRetorn = proveidorBusiness.guardaProveidor(proveidor);
			if ((proveidorRetorn == null)) {
				return new ResponseEntity<>("El proveidor ja existeix", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>("Proveïdor donat d'alta correctament", httpHeaders, HttpStatus.OK);
			}
		} catch (final Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@RequestMapping(path = "/baixa", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> baixa(
			@RequestBody final Proveidor proveidor) {

		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final Proveidor proveidorRetorn = proveidorBusiness.eliminaProveidor(proveidor);
			if ((proveidorRetorn == null)) {
				return new ResponseEntity<>("La proveidor no s'ha pogut eliminar", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>("Proveidor donat de baixa correctament", httpHeaders, HttpStatus.OK);
			}
		} catch (final Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(path = "/modificacio", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> modificacio(
			@RequestBody final Proveidor proveidor) {

		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final Proveidor proveidorRetorn = proveidorBusiness.modificaProveidor(proveidor);
			if ((proveidorRetorn == null)) {
				return new ResponseEntity<>("No s’ha pogut modificar el proveidor", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>("Proveidor modificat correctament", httpHeaders, HttpStatus.OK);
			}
		} catch (final Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@RequestMapping(path = "/cercar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getProveidros(
			@RequestBody final Cercador cercadorProveidor) {

		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final List<Proveidor> listProveidor = proveidorBusiness.cercarProveidor(cercadorProveidor);
			if ((listProveidor.size()== 0)) {
				return new ResponseEntity<>("No s'han trobat resultats", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(listProveidor, httpHeaders, HttpStatus.OK);
			}
		} catch (final Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}

