package es.upm.isst.amigoinvisible.datastore;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

import es.upm.isst.amigoinvisible.model.Usuario;

public class UserDaoImplTest {
	
	private final LocalServiceTestHelper helper =
            new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

	@Before
	public void setUp() throws Exception {
		helper.setUp();
	}

	@After
	public void tearDown() throws Exception {
		helper.tearDown();
	}

	@Test
	public void testSaveUser() {
		UserDao dao = UserDaoImpl.getInstance();
		Usuario user = new Usuario("admin", "admin@admin.com", ""+System.currentTimeMillis());
		dao.saveUser(user.getUsername(), user.getEmail(), user.getUserId());
		
		assertEquals("admin", user.getUsername());
	}

	@Test
	public void testGetUserByName() {
		UserDao dao = UserDaoImpl.getInstance();
		Usuario user = new Usuario("admin", "admin@admin.com", ""+System.currentTimeMillis());
		dao.saveUser(user.getUsername(), user.getEmail(), user.getUserId());
		
		Usuario result = dao.getUserByName("admin");
		assertEquals("admin@admin.com", result.getEmail());
	}

	@Test
	public void testSaveUserWithPassword() {
		UserDao dao = UserDaoImpl.getInstance();
		Usuario user = new Usuario("admin", "admin@admin.com", "admin1234", ""+System.currentTimeMillis());
		dao.saveUserWithPassword(user.getUsername(), user.getEmail(), user.getPassword(), user.getUserId());
		
		assertEquals("admin", user.getUsername());
	}

	@Test
	public void testGetUserByEmail() {
		UserDao dao = UserDaoImpl.getInstance();
		Usuario user = new Usuario("admin", "admin@admin.com", ""+System.currentTimeMillis());
		dao.saveUser(user.getUsername(), user.getEmail(), user.getUserId());
		
		Usuario result = dao.getUserByEmail("admin@admin.com");
		assertEquals("admin", result.getUsername());
	}

	@Test
	public void testUpdateUser() {
		UserDao dao = UserDaoImpl.getInstance();
		Usuario user = new Usuario("admin", "admin@admin.com", ""+System.currentTimeMillis());
		dao.saveUser(user.getUsername(), user.getEmail(), user.getUserId());
		
		user.setUsername("admin2");
		dao.updateUser(user);
		
		Usuario result = dao.getUserByEmail("admin@admin.com");
		assertEquals("admin2", result.getUsername());
	}

	@Test
	public void testGetUserByID() {
		UserDao dao = UserDaoImpl.getInstance();
		String userId = String.valueOf(System.currentTimeMillis());
		Usuario user = new Usuario("admin", "admin@admin.com", userId);
		dao.saveUser(user.getUsername(), user.getEmail(), user.getUserId());
		
		Usuario result = dao.getUserByID(userId);
		assertEquals("admin", result.getUsername());
	}

}
