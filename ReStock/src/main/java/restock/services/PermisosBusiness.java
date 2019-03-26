package restock.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import restock.entities.Permisos;
import restock.repository.PermisosRepository;

@Component
public class PermisosBusiness {

	@Autowired
	private PermisosRepository permisosRepository;


	public List<Permisos> getPermisosPerRol(final Integer rolId) {
		return permisosRepository.findByRolId(rolId);
	}
	
	public List<Permisos> getTotsElsPermisos() {
		return permisosRepository.findAll();
	}

}