/*
 * 
 * Albert Codina
 */
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
import restock.entities.Producte;
import restock.entities.Proveidor;
import restock.entities.Usuari;
import restock.services.BotigaBusiness;
import restock.services.OrganitzacioBusiness;
import restock.services.ProducteBusiness;
import restock.services.ProveidorBusiness;
import restock.services.UsuariBusiness;


/**
 * The Class OrganitzacioController.
 */
@RestController
@RequestMapping("/organitzacio")
public class OrganitzacioController {
    
    @Autowired
    private OrganitzacioBusiness organitzacioBusiness;
    
    @Autowired
    private BotigaBusiness botigaBusiness;
    
    @Autowired
    private ProveidorBusiness proveidorBusiness;
    
    @Autowired
    private ProducteBusiness producteBusiness;
    
    @Autowired
    private UsuariBusiness usuariBusiness;

    /**
     * Organitzacio controller.
     */
    public OrganitzacioController(){
    }
 
    
	/**
	 * Alta.
	 *
	 * @param organitzacio the organitzacio
	 * @return response entity
	 */
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
	
	/**
	 * Gets usuaris per organitzacio.
	 *
	 * @param orgId the org id
	 * @return usuaris per organitzacio
	 */
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
	
	/**
	 * Gets botigues per organitzacio.
	 *
	 * @param orgId the org id
	 * @return botigues per organitzacio
	 */
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
	
	/**
	 * Gets proveidors per organitzacio.
	 *
	 * @param orgId the org id
	 * @return proveidors per organitzacio
	 */
	@RequestMapping(path = "/proveidors/{orgId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getProveidorsPerOrganitzacio(@PathVariable final Integer orgId) {
		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final List<Proveidor> proveidorList = proveidorBusiness.getProveidorsPerOrganitzacio(orgId);
			if ((proveidorList.size() == 0)) {
				return new ResponseEntity<>("Aquest organització no té proveïdors", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(proveidorList, httpHeaders, HttpStatus.OK);
			}
		}catch(final Exception e){	
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NO_CONTENT);
		}
	}
	
	/**
	 * Gets productes per proveidor id.
	 *
	 * @param provId the prov id
	 * @return productes per proveidor id
	 */
	@RequestMapping(path = "/productes/{provId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getProductesPerProveidorId(@PathVariable final Integer provId) {
		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final List<Producte> productesList = producteBusiness.getProductesPerProveidor(provId);
			if ((productesList.size() == 0)) {
				return new ResponseEntity<>("Aquest proveidor no té productes", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(productesList, httpHeaders, HttpStatus.OK);
			}
		}catch(final Exception e){	
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NO_CONTENT);
		}
	}
}

