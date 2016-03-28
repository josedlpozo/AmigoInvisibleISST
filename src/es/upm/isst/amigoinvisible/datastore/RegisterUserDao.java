package es.upm.isst.amigoinvisible.datastore;

import javax.persistence.EntityManager;
import es.upm.isst.amigoinvisible.model.Usuario;

public class RegisterUserDao {
	
	private EntityManager persistenceManager;
	
	public RegisterUserDao(){
		persistenceManager = PersistenceManager.get().createEntityManager();
	}
	
	public void addUser(Usuario user, Callback callback){
		try{
			persistenceManager.persist(user);
		}finally{
			callback.onUserSaved(user);
		}
	}
	
	public interface Callback {
        void onUserSaved(Usuario professor);
    }
}
