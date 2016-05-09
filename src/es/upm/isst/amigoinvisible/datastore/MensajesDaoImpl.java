package es.upm.isst.amigoinvisible.datastore;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import es.upm.isst.amigoinvisible.model.Comunidad;
import es.upm.isst.amigoinvisible.model.Mensaje;

public class MensajesDaoImpl implements MensajesDao {
	
	private static MensajesDaoImpl instance;

	private MensajesDaoImpl(){}

	public static MensajesDaoImpl getInstance(){
		if(instance == null) instance = new MensajesDaoImpl();
		return instance;
	}

	@Override
	public void saveMensaje(String userId, String comunidadId, String mensaje) {
		EntityManager em = PersistenceManager.get().createEntityManager();
		
		Mensaje m = new Mensaje(userId, comunidadId, mensaje);
		em.persist(m);
		em.close();
	}

	@Override
	public List<Mensaje> getMensajesByComunidadID(String comunidadId) {
		EntityManager em = PersistenceManager.get().createEntityManager();
		
		Query q = em.createQuery("select t from Mensaje t");

		List<Mensaje> mensajes = q.getResultList();

		em.close();
		
		List<Mensaje> mensajesPorComunidad = new ArrayList<>();

		if(mensajes != null){
			for(Mensaje m : mensajes){
				if(m.getComunidadId().equals(comunidadId)) mensajesPorComunidad.add(m);
			}
		}
		
		return mensajesPorComunidad;
	}

}
