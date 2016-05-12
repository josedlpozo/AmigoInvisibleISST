package es.upm.isst.amigoinvisible.datastore;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import es.upm.isst.amigoinvisible.model.Comunidad;
import es.upm.isst.amigoinvisible.model.Usuario;

public class ComunidadDaoImpl implements ComunidadDao{
	
	private static ComunidadDaoImpl instance;

	private ComunidadDaoImpl(){}

	public static ComunidadDaoImpl getInstance(){
		if(instance == null) instance = new ComunidadDaoImpl();
		return instance;
	}

	@Override
	public void guardarComunidad(String name, String gestorId, String password, List<String> usuariosId,
			String comunidadId) {
		EntityManager em = PersistenceManager.get().createEntityManager();

		Comunidad comunidad = new Comunidad(name, gestorId, password, usuariosId, comunidadId);

		em.persist(comunidad);
		em.close();
	}

	@Override
	public Comunidad getComunidadByName(String comunidadName) {
		EntityManager em = PersistenceManager.get().createEntityManager();

		Query q = em.createQuery("select t from Comunidad t");

		List<Comunidad> comunidades = q.getResultList();

		em.close();

		if(comunidades != null){
			for(Comunidad c : comunidades){
				if(c.getNombre().equals(comunidadName)) return c;
			}
		}

		return null;
	}

	@Override
	public List<Comunidad> getComunidadesByUser(String userId) {
		EntityManager em = PersistenceManager.get().createEntityManager();

		Query q = em.createQuery("select t from Comunidad t");

		List<Comunidad> comunidades = q.getResultList();

		em.close();
		List<Comunidad> comunidadByUser = new ArrayList<>();
		if(comunidades != null){
			for(Comunidad c : comunidades){
				if(c.getGestorId().equals(userId)) comunidadByUser.add(c);
				for(String u : c.getUsuariosId()){
					if(u.equals(userId)) comunidadByUser.add(c);
				}
			}
		}
		return comunidadByUser;
	}

	@Override
	public void actualizaComunidad(Comunidad comunidad) {
		EntityManager em = PersistenceManager.get().createEntityManager();

		em.merge(comunidad);
		em.close();
	}

	@Override
	public Comunidad getComunidadByID(String comunidadId) {
		EntityManager em = PersistenceManager.get().createEntityManager();
		try{
			return em.find(Comunidad.class, comunidadId);
		}catch(Exception e){
			return null;
		}
	}

}
