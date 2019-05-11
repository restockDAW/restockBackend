/*
 * 
 * Albert Codina
 */
package restock.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;


import restock.entities.Permisos;
import restock.entities.Rol;
import restock.services.PermisosBusiness;


/**
 * The Class PermisosController.
 */
@RestController
@RequestMapping("/permisos")
public class PermisosController {
    
    @Autowired
    private PermisosBusiness permisosBusiness;

    /**
     * Permisos controller.
     */
    public PermisosController(){
    }
 
    
	/**
	 * Gets tots permisos.
	 *
	 * @param rol the rol
	 * @return tots permisos
	 */
	@RequestMapping(path = "/totsElsPermisos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getTotsPermisos(final Rol rol) {
		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final List<Permisos> permisos = permisosBusiness.getTotsElsPermisos();
			return new ResponseEntity<>(permisos, httpHeaders, HttpStatus.OK);
		}catch(final Exception e){	
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NO_CONTENT);
		}
	}
	
	/**
	 * Gets permisos per rol.
	 *
	 * @param rolId the rol id
	 * @return permisos per rol
	 */
	@RequestMapping(path = "/permisPerRol/{rolId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getPermisosPerRol(@PathVariable final Integer rolId) {
		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final List<Permisos> permisos = permisosBusiness.getPermisosPerRol(rolId);
			return new ResponseEntity<>(permisos, httpHeaders, HttpStatus.OK);
		}catch(final Exception e){	
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NO_CONTENT);
		}
	}
}

