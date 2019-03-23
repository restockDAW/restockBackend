package restock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import restock.entities.Usuari;
import restock.services.UsuariBusiness;


@RestController
@RequestMapping("/usuari")
public class UsuariController {
    
    @Autowired
    private UsuariBusiness usuariBusiness;

    public UsuariController(){
    }
 
    
	@RequestMapping(path = "/alta", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> alta(
			@RequestBody final Usuari usuari) {

		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final Usuari usuariRetorn = usuariBusiness.guardaUsuari(usuari);
			if ((usuariRetorn == null)) {
				return new ResponseEntity<>("El responsable ja existeix", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>("Responsable donat d'alta correctament", httpHeaders, HttpStatus.OK);
			}
		} catch (final Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	};
	
	@RequestMapping(path = "/baixa", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> baixa(
			@RequestBody final Usuari usuari) {

		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final Usuari usuariRetorn = usuariBusiness.eliminaUsuari(usuari);
			if ((usuariRetorn == null)) {
				return new ResponseEntity<>("El responsable no es pot eliminar ja és un administrador", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>("Responsable donat de baixa correctament", httpHeaders, HttpStatus.OK);
			}
		} catch (final Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	};
	
	@RequestMapping(path = "/modificacio", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> modificacio(
			@RequestBody final Usuari usuari) {

		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final Usuari usuariRetorn = usuariBusiness.modificaUsuari(usuari);
			if ((usuariRetorn == null)) {
				return new ResponseEntity<>("No s’ha pogut modificar el responsable", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>("Responsable modificat correctament", httpHeaders, HttpStatus.OK);
			}
		} catch (final Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	};
	
	@RequestMapping(path = "/cercar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> cercar(
			@RequestBody final Usuari usuari) {

		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final List<Usuari> listUsuaris = usuariBusiness.cercarUsuari(usuari);
			if ((listUsuaris.size()!= 0)) {
				return new ResponseEntity<>("No s'han trobat resultats", httpHeaders, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(listUsuaris, httpHeaders, HttpStatus.OK);
			}
		} catch (final Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	};
}

