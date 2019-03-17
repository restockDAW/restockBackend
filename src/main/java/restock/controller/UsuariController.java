package restock.controller;

import java.util.List;
import java.util.Map;

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

import restock.entities.Organitzacio;
import restock.entities.Usuari;
import restock.services.UsuarisBusiness;


@RestController
@RequestMapping("/usuaris")
public class UsuariController {
    
    @Autowired
    private UsuarisBusiness usuariBusiness;

    public UsuariController(){
    }
 
    
	@RequestMapping(path = "/altaAdministrador", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> altaAdministrador(
			@RequestBody final Organitzacio organitzacio) {

		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
//			if (organitzacio == null) {
//				throw new Exception("No s'han introduit les dades de l'organització i l'administrador");
//			}
			final Organitzacio organitzacioRetorn = usuariBusiness.guardaAdministrador(organitzacio);
			if ((organitzacioRetorn == null)) {
				return new ResponseEntity<>("La organització o l'administrador ja existeixen", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(organitzacioRetorn, httpHeaders, HttpStatus.OK);
			}
		} catch (final Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	};
}

