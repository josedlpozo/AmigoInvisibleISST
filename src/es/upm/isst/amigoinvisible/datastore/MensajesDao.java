package es.upm.isst.amigoinvisible.datastore;

import java.util.List;

import es.upm.isst.amigoinvisible.model.Mensaje;

public interface MensajesDao {
	
	void saveMensaje(String userId, String comunidadId, String mensaje);
	
	List<Mensaje> getMensajesByComunidadID(String comunidadId);
}
