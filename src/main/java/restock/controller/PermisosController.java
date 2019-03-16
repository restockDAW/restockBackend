package restock.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
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


@RestController
@RequestMapping("/permisos")
public class PermisosController {
    
    @Autowired
    private PermisosBusiness permisosBusiness;

    public PermisosController(){
    }
 
    
	@RequestMapping(path = "/permis", method = RequestMethod.GET)
	public ResponseEntity<?> getTotsPermisos(final Rol rol) {
		try {
			final HttpHeaders httpHeaders = new HttpHeaders();
			final List<Permisos> permisos = permisosBusiness.getAll();
			return new ResponseEntity<>(permisos, httpHeaders, HttpStatus.OK);
		}catch(final Exception e){	
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(path = "/permis/{rolId}", method = RequestMethod.GET)
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

