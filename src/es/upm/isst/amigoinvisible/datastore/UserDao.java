package es.upm.isst.amigoinvisible.datastore;

import java.util.List;

import javax.persistence.EntityManager;
import es.upm.isst.amigoinvisible.model.Usuario;

public interface UserDao {
	void saveUser(String name, String email, String userId);
	
	void saveUserWithPassword(String name, String email, String password, String userId);
	
	void saveUserWithList(String name, String email, List<String> deseos,String userId);
	
	Usuario getUserByName(String userName);
	
	Usuario getUserByEmail(String email);
	
	Usuario getUserByID(String userId);
	
	void updateUser(Usuario user);
}
