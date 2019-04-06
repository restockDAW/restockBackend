package restock.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;

import restock.entities.Botiga;
import restock.entities.Organitzacio;
import restock.entities.Usuari;
import restock.services.BotigaBusiness;
import restock.services.OrganitzacioBusiness;


@RestController
@RequestMapping("/botiga")
public class BotigaController {
    
    @Autowired
    private BotigaBusiness botigaBusiness;

    public BotigaController(){
    }
 
	@RequestMapping(path = "/alta", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> alta(
			@RequestBody final Botiga botiga) {

		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final Botiga botigaRetorn = botigaBusiness.guardaBotiga(botiga);
			if ((botigaRetorn == null)) {
				return new ResponseEntity<>("La botiga ja existeix", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>("Botiga donada d'alta correctament", httpHeaders, HttpStatus.OK);
			}
		} catch (final Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	};
	
	
	@RequestMapping(path = "/baixa", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> baixa(
			@RequestBody final Botiga botiga) {

		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final Botiga botigaRetorn = botigaBusiness.eliminaBotiga(botiga);
			if ((botigaRetorn == null)) {
				return new ResponseEntity<>("La botiga no s'ha pogut eliminar", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>("Botiga donada de baixa correctament", httpHeaders, HttpStatus.OK);
			}
		} catch (final Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	};
	
	@RequestMapping(path = "/modificacio", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> modificacio(
			@RequestBody final Botiga botiga) {

		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final Botiga botigaRetorn = botigaBusiness.modificaBotiga(botiga);
			if ((botigaRetorn == null)) {
				return new ResponseEntity<>("No s’ha pogut modificar la botiga", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>("Botiga modificada correctament", httpHeaders, HttpStatus.OK);
			}
		} catch (final Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	};
}

