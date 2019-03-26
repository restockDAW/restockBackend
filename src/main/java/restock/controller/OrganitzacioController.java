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

import restock.entities.Organitzacio;
import restock.services.OrganitzacioBusiness;


@RestController
@RequestMapping("/organitzacio")
public class OrganitzacioController {
    
    @Autowired
    private OrganitzacioBusiness organitzacioBusiness;

    public OrganitzacioController(){
    }
 
    
	@RequestMapping(path = "/alta", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> alta(
			@RequestBody final Organitzacio organitzacio) {

		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final Organitzacio organitzacioRetorn = organitzacioBusiness.guardaAdministrador(organitzacio);
			if ((organitzacioRetorn == null)) {
				return new ResponseEntity<>("La organització o l'administrador ja existeixen", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>("Organització i administrador donats d'alta correctament", httpHeaders, HttpStatus.OK);
			}
		} catch (final Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	};
}

