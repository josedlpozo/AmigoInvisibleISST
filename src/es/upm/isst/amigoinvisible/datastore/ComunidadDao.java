package es.upm.isst.amigoinvisible.datastore;

import java.util.List;

import es.upm.isst.amigoinvisible.model.Comunidad;
import es.upm.isst.amigoinvisible.model.Usuario;

public interface ComunidadDao {
	void guardarComunidad(String name, String gestorId, String password, List<String> usuariosId, String comunidadId);
	
	Comunidad getComunidadByName(String comunidadName);
	
	List<Comunidad> getComunidadesByUser(String userName);
	
	void actualizaComunidad(Comunidad comunidad);
	
	Comunidad getComunidadByID(String comunidadId);
}
