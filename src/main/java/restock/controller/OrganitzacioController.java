package restock.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;

import restock.entities.Botiga;
import restock.entities.Organitzacio;
import restock.entities.Usuari;
import restock.services.BotigaBusiness;
import restock.services.OrganitzacioBusiness;
import restock.services.UsuariBusiness;


@RestController
@RequestMapping("/organitzacio")
public class OrganitzacioController {
    
    @Autowired
    private OrganitzacioBusiness organitzacioBusiness;
    
    @Autowired
    private BotigaBusiness botigaBusiness;
    
    @Autowired
    private UsuariBusiness usuariBusiness;

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
	}
	
	@RequestMapping(path = "/usuaris/{orgId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getUsuarisPerOrganitzacio(@PathVariable final Integer orgId) {
		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final List<Usuari> usuariList = usuariBusiness.getUsuarisPerOrganitzacio(orgId);
			if ((usuariList.size() == 0)) {
				return new ResponseEntity<>("Aquest organització no té usuaris", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(usuariList, httpHeaders, HttpStatus.OK);
			}
		}catch(final Exception e){	
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(path = "/botigues/{orgId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getBotiguesPerOrganitzacio(@PathVariable final Integer orgId) {
		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final List<Botiga> botigaList = botigaBusiness.getBotiguesPerOrganitzacio(orgId);
			if ((botigaList.size() == 0)) {
				return new ResponseEntity<>("Aquest organització no té botigues", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(botigaList, httpHeaders, HttpStatus.OK);
			}
		}catch(final Exception e){	
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NO_CONTENT);
		}
	}
}

