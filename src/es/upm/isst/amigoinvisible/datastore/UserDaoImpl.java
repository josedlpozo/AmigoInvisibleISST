package es.upm.isst.amigoinvisible.datastore;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import es.upm.isst.amigoinvisible.model.Usuario;

public class UserDaoImpl implements UserDao{

	private static UserDaoImpl instance;

	private UserDaoImpl(){}

	public static UserDaoImpl getInstance(){
		if(instance == null) instance = new UserDaoImpl();
		return instance;
	}

	@Override
	public void saveUser(String name, String email, String userId) {
		EntityManager em = PersistenceManager.get().createEntityManager();

		Usuario usuario = new Usuario(name, email, userId);

		em.persist(usuario);
		em.close();
	}

	@Override
	public Usuario getUserByName(String userName) {
		EntityManager em = PersistenceManager.get().createEntityManager();

		Query q = em.createQuery("select t from Usuario t");

		List<Usuario> users = q.getResultList();

		em.close();

		if(users != null){
			for(Usuario u : users){
				if(u.getUsername().equals(userName)) return u;
			}
		}

		return null;
	}

	@Override
	public void saveUserWithPassword(String name, String email, String password, String userId) {
		EntityManager em = PersistenceManager.get().createEntityManager();

		Usuario usuario = new Usuario(name, email, password, userId);

		em.persist(usuario);
		em.close();
	}

	@Override
	public void updateUser(Usuario user) {
		EntityManager em = PersistenceManager.get().createEntityManager();
		
		em.merge(user);
		em.close();
		
	}
}
