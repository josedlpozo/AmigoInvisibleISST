package es.upm.isst.amigoinvisible.datastore;

import javax.persistence.EntityManager;
import es.upm.isst.amigoinvisible.model.Usuario;

public interface UserDao {
	void saveUser(String name, String email, String userId);
	
	void saveUserWithPassword(String name, String email, String password, String userId);
	
	Usuario getUserByName(String userName);
	
	Usuario getUserByEmail(String email);
	
	void updateUser(Usuario user);
}
