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

import restock.entities.Familia;
import restock.entities.Producte;
import restock.entities.SubFamilia;
import restock.services.ProducteBusiness;


@RestController
@RequestMapping("/producte")
public class ProducteController {
    
    @Autowired
    private ProducteBusiness producteBusiness;
    

    public ProducteController(){
    }
 
    
	@RequestMapping(path = "/alta", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> alta(
			@RequestBody final Producte producte) {

		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final Producte producteRetorn = producteBusiness.guardaProducte(producte);
			if ((producteRetorn == null)) {
				return new ResponseEntity<>("El producte ja existeix", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>("Producte donat d'alta correctament", httpHeaders, HttpStatus.OK);
			}
		} catch (final Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@RequestMapping(path = "/baixa", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> baixa(
			@RequestBody final Producte producte) {

		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final Producte producteRetorn = producteBusiness.eliminaProducte(producte);
			if ((producteRetorn == null)) {
				return new ResponseEntity<>("El producte no s'ha pogut eliminar", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>("Producte donat de baixa correctament", httpHeaders, HttpStatus.OK);
			}
		} catch (final Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	};
	
	@RequestMapping(path = "/modificacio", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> modificacio(
			@RequestBody final Producte producte) {

		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final Producte producteRetorn = producteBusiness.modificaProducte(producte);
			if ((producteRetorn == null)) {
				return new ResponseEntity<>("No s’ha pogut modificar el producte", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>("Producte modificat correctament", httpHeaders, HttpStatus.OK);
			}
		} catch (final Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	};
	
	@RequestMapping(path = "/families", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getFamilies() {
		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final List<Familia> familiaList = producteBusiness.getFamilies();
			if ((familiaList.size() == 0)) {
				return new ResponseEntity<>("No existeixen families", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(familiaList, httpHeaders, HttpStatus.OK);
			}
		}catch(final Exception e){	
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(path = "/subfamilia/{famId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getSubfamiliesPerFamiliaId(@PathVariable final Integer famId) {
		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final List<SubFamilia> subfamiliaList = producteBusiness.getSubfamiliaPerFamilia(famId);
			if ((subfamiliaList.size() == 0)) {
				return new ResponseEntity<>("Aquesta familia no té subfamilies", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(subfamiliaList, httpHeaders, HttpStatus.OK);
			}
		}catch(final Exception e){	
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NO_CONTENT);
		}
	}
}
